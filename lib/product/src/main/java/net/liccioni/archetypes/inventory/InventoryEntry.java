package net.liccioni.archetypes.inventory;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.rule.RuleSet;

@Data
@SuperBuilder(toBuilder = true)
public class InventoryEntry {

    private final RuleSet availabilityPolicy;
    private final ProductType productType;

    @Builder.Default
    private final Set<ProductInstance> productInstances = new HashSet<>();

    public int getNumberAvailable() {
        //TODO
        return 0;
    }

    public int getNumberReserved() {
        //TODO
        return 0;
    }

    public boolean canAcceptReservationRequest(ReservationRequest request) {
        //TODO
        return false;
    }
}
