package net.liccioni.archetypes.product.service;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.product.ProductType;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class ServiceType extends ProductType {

    TimeDate startPeriodOfOperation;
    TimeDate endPeriodOfOperation;
}
