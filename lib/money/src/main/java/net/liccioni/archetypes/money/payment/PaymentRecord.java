package net.liccioni.archetypes.money.payment;

import lombok.Builder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.Currency;
import net.liccioni.archetypes.quantity.Quantity;

import java.math.BigDecimal;

public record PaymentRecord(TimeDate dateMade,
                            TimeDate dateReceived,
                            TimeDate dateDue,
                            TimeDate dateCreated,
                            PaymentMethod paymentMethod,
                            String toAccount,
                            String fromAccount,
                            BigDecimal amount,
                            Currency currency) implements Payment {
    @Builder(toBuilder = true)
    public PaymentRecord(TimeDate dateMade,
                         TimeDate dateReceived,
                         TimeDate dateDue,
                         TimeDate dateCreated,
                         PaymentMethod paymentMethod,
                         String toAccount,
                         String fromAccount,
                         Number amount,
                         Currency currency) {
        this(dateMade,
                dateReceived,
                dateDue,
                dateCreated,
                paymentMethod,
                toAccount,
                fromAccount,
                BigDecimal.valueOf(amount.doubleValue()),
                currency);
    }

    @Override
    public Quantity withAmount(BigDecimal amount) {
        return this.toBuilder().amount(amount).build();
    }
}
