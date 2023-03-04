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

    @Builder.Default
    RestockPolicy restockPolicy = RestockPolicy.builder().build();
    @Builder.Default
    Set<PurchaseOrder> outstandingPurchaseOrders = new HashSet<>();

    public boolean restock(RuleContext context) {
        return restockPolicy.getRuleSet().evaluate(context);
    }

    public int getQuantityExpectedByDate(TimeDate date) {
        //TODO
        return 0;
    }
}
