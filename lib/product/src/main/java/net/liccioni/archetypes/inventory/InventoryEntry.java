package net.liccioni.archetypes.inventory;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.rule.RuleSet;

@Data
@SuperBuilder(toBuilder = true)
public class InventoryEntry {

    @NonNull
    private final ProductType productType;
    private final RuleSet availabilityPolicy;

    @Builder.Default
    private final Set<ProductInstance> productInstances = new HashSet<>();

    public long getNumberAvailable() {
        return productInstances.stream()
                .filter(p -> ReservationStatus.AVAILABLE.equals(p.getReservationStatus()))
                .count();
    }

    public long getNumberReserved() {
        return productInstances.stream()
                .filter(p -> ReservationStatus.RESERVED.equals(p.getReservationStatus()))
                .count();
    }

    public boolean canAcceptReservationRequest(ReservationRequest request) {
        return productInstances.stream().anyMatch(p -> ReservationStatus.AVAILABLE.equals(p.getReservationStatus()));
    }
}
