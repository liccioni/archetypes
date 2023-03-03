package net.liccioni.archetypes.inventory;


import net.liccioni.archetypes.product.service.ServiceInstance;


public interface CapacityManager {

    void releaseServiceInstance(ServiceInstance serviceInstance);
}
