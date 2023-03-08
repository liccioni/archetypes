package net.liccioni.archetypes.order.discount;


import java.math.BigDecimal;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.money.Money;
import net.liccioni.archetypes.product.price.Price;
import net.liccioni.archetypes.quantity.Quantity;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class MonetaryDiscount extends Discount {

    Double amount;

    @Override
    public Price calculateDiscountedPrice(final Price price) {
        var discountMoney = price.getAmount().withAmount(BigDecimal.valueOf(amount));
        final Money subtract = (Money) price.getAmount().subtract(discountMoney);
        return price.toBuilder().amount(subtract).build();
    }
}
