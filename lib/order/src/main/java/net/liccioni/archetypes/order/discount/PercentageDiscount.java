package net.liccioni.archetypes.order.discount;

import lombok.Builder;
import net.liccioni.archetypes.money.Money;
import net.liccioni.archetypes.product.price.Price;

@Builder(toBuilder = true)
public record PercentageDiscount(String reason, Double percentage) implements Discount {

    @Override
    public Price calculateDiscountedPrice(final Price price) {
        var discountMoney = price.amount().multiply(percentage / 100);
        final Money subtract = (Money) price.amount().subtract(discountMoney);
        return price.setAmount(subtract);
    }
}
