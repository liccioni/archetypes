package net.liccioni.archetypes.money;

import lombok.Builder;
import net.liccioni.archetypes.quantity.Quantity;

import java.math.BigDecimal;


public record MoneyRecord(BigDecimal amount, Currency currency) implements Money {
    @Builder(toBuilder = true, builderMethodName = "moneyBuilder")
    public MoneyRecord(Number amount, Currency currency) {
        this(BigDecimal.valueOf(amount.doubleValue()), currency);
    }

    @Override
    public Quantity withAmount(BigDecimal amount) {
        return this.toBuilder().amount(amount).build();
    }
}
