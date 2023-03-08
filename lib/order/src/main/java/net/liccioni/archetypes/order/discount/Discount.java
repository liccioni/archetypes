package net.liccioni.archetypes.order.discount;


import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.product.price.Price;

@Data
@SuperBuilder(toBuilder = true)
public abstract class Discount {

    private final String reason;
    private final DiscountType discountType;

    public abstract Price calculateDiscountedPrice(Price price);
}
