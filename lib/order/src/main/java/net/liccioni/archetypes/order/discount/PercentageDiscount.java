package net.liccioni.archetypes.order.discount;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.money.Money;
import net.liccioni.archetypes.product.price.Price;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class PercentageDiscount extends Discount {

    Double percentage;

    @Override
    public Price calculateDiscountedPrice(final Price price) {
        var discountMoney = price.getAmount().multiply(percentage / 100);
        final Money subtract = (Money) price.getAmount().subtract(discountMoney);
        return price.toBuilder().amount(subtract).build();
    }
}
