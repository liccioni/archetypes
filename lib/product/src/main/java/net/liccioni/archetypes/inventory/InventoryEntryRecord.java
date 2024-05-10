package net.liccioni.archetypes.inventory;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.rule.RuleSet;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record InventoryEntryRecord(ProductType productType,
                                   RuleSet availabilityPolicy,
                                   Set<ProductInstance> productInstances) implements InventoryEntry {
    @Builder(toBuilder = true)
    public InventoryEntryRecord(@NonNull ProductType productType, RuleSet availabilityPolicy, Set<ProductInstance> productInstances) {
        this.productType = productType;
        this.availabilityPolicy = Optional.ofNullable(availabilityPolicy).orElseGet(() -> RuleSet.builder().build());
        this.productInstances = Optional.ofNullable(productInstances).orElseGet(HashSet::new);
    }
}
