package net.liccioni.archetypes.inventory;

import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.rule.RuleSet;

import java.util.Set;

public interface InventoryEntry {

    ProductType productType();

    RuleSet availabilityPolicy();

    Set<ProductInstance> productInstances();

    default long getNumberAvailable() {
        return productInstances().stream()
                .filter(p -> ReservationStatus.AVAILABLE.equals(p.reservationStatus()))
                .count();
    }

    default long getNumberReserved() {
        return productInstances().stream()
                .filter(p -> ReservationStatus.RESERVED.equals(p.reservationStatus()))
                .count();
    }

    default boolean canAcceptReservationRequest(ReservationRequest request) {
        var ap = availabilityPolicy().toBuilder().build();
        request.overrides().forEach(ap::addRuleOverride);
        return productType().productIdentifier().equals(request.productIdentifier()) &&
                ap.evaluate(request.context()) &&
                getNumberAvailable() >= request.numberRequested();
    }
}
