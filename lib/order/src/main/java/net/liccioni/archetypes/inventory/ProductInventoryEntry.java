package net.liccioni.archetypes.inventory;


import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.PurchaseOrder;
import net.liccioni.archetypes.rule.RuleContext;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class ProductInventoryEntry extends InventoryEntry {

    RestockPolicy restockPolicy;
    @Builder.Default
    Set<PurchaseOrder> outstandingPurchaseOrders = new HashSet<>();

    public boolean restock(RuleContext context) {
        //TODO
        return false;
    }

    public int getQuantityExpectedByDate(TimeDate date) {
        //TODO
        return 0;
    }
}
