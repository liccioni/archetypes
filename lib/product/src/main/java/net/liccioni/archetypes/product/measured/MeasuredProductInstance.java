package net.liccioni.archetypes.product.measured;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.quantity.Quantity;

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class MeasuredProductInstance extends ProductInstance {

    Quantity quantity;
}
