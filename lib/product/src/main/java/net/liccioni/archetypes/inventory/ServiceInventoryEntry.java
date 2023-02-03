package net.liccioni.archetypes.inventory;


import java.util.Set;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.product.ServiceInstance;

/**
 * @generated
 */
public class ServiceInventoryEntry extends InventoryEntry {

    /**
     * @generated
     */
    private CapacityManager capacityManager;

    /**
     * @generated
     */
    public CapacityManager getCapacityManager() {
        return this.capacityManager;
    }

    /**
     * @generated
     */
    public void setCapacityManager(CapacityManager capacityManager) {
        this.capacityManager = capacityManager;
    }

    /**
     * @generated
     */
    public Set<ServiceInstance> getProductInstances(TimeDate start, TimeDate end) {
        //TODO
        return null;
    }


}
