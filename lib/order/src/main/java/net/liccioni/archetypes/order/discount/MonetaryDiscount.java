package net.liccioni.archetypes.order.discount;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.product.price.Price;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class MonetaryDiscount extends Discount {

    @Override
    public Price calculateDiscountedPrice(final Price price) {
        return null;
    }
}
