package net.liccioni.archetypes.inventory;


import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.PurchaseOrder;
import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleSet;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Builder(toBuilder = true)
public record ProductInventoryEntry(ProductType productType,
                                    RuleSet availabilityPolicy,
                                    Set<ProductInstance> productInstances,
                                    RestockPolicy restockPolicy,
                                    Set<PurchaseOrder> outstandingPurchaseOrders) implements InventoryEntry {

    public ProductInventoryEntry(@NonNull ProductType productType,
                                 RuleSet availabilityPolicy,
                                 Set<ProductInstance> productInstances,
                                 RestockPolicy restockPolicy,
                                 Set<PurchaseOrder> outstandingPurchaseOrders) {
        this.productType = productType;
        this.availabilityPolicy = Optional.ofNullable(availabilityPolicy).orElseGet(() -> RuleSet.builder().build());
        this.productInstances = Optional.ofNullable(productInstances).orElseGet(HashSet::new);
        this.restockPolicy = Optional.ofNullable(restockPolicy).orElseGet(() -> RestockPolicy.builder().build());
        this.outstandingPurchaseOrders = Optional.ofNullable(outstandingPurchaseOrders).orElseGet(HashSet::new);
    }

    public boolean restock(RuleContext context) {
        return restockPolicy.ruleSet().evaluate(context);
    }

    public int getQuantityExpectedByDate(TimeDate date) {
        //TODO
        return 0;
    }
}
