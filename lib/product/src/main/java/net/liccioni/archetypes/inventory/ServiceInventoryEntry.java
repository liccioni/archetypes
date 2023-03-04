package net.liccioni.archetypes.inventory;


import java.util.Set;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.product.service.ServiceInstance;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class ServiceInventoryEntry extends InventoryEntry {

    CapacityManager capacityManager;

    public Set<ServiceInstance> getProductInstances(TimeDate start, TimeDate end) {

        return super.getProductInstances().stream().map(ServiceInstance.class::cast).collect(Collectors.toSet());
    }
}
