package net.liccioni.archetypes.inventory;


import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.product.service.ServiceInstance;
import net.liccioni.archetypes.rule.RuleSet;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Builder(toBuilder = true)
public record ServiceInventoryEntry(
        @NonNull
        ProductType productType,
        RuleSet availabilityPolicy,
        Set<ProductInstance> productInstances,
        CapacityManager capacityManager
) implements InventoryEntry {

    public ServiceInventoryEntry(@NonNull
                                 ProductType productType,
                                 RuleSet availabilityPolicy,
                                 Set<ProductInstance> productInstances,
                                 CapacityManager capacityManager) {
        this.productType = productType;
        this.availabilityPolicy = Optional.ofNullable(availabilityPolicy).orElseGet(() -> RuleSet.builder().build());
        this.productInstances = Optional.ofNullable(productInstances).orElseGet(HashSet::new);
        this.capacityManager = capacityManager;
    }

    public Set<ServiceInstance> getProductInstances(TimeDate start, TimeDate end) {
        return productInstances.stream().map(ServiceInstance.class::cast).collect(Collectors.toSet());
    }
}
