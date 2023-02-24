package net.liccioni.archetypes.product.service;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.product.ProductInstance;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class ServiceInstance extends ProductInstance {

    TimeDate start;
    TimeDate end;
    TimeDate scheduledStart;
    TimeDate scheduledEnd;
    ServiceDeliveryStatus serviceDeliverStatus;
}
