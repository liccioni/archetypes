package net.liccioni.archetypes.order.discount;


import lombok.Builder;
import net.liccioni.archetypes.money.Money;
import net.liccioni.archetypes.product.price.Price;

import java.math.BigDecimal;

@Builder(toBuilder = true)
public record MonetaryDiscount(String reason, Double amount) implements Discount {
    @Override
    public Price calculateDiscountedPrice(final Price price) {
        var discountMoney = price.amount().withAmount(BigDecimal.valueOf(amount));
        final Money subtract = (Money) price.amount().subtract(discountMoney);
        return price.setAmount(subtract);
    }
}
