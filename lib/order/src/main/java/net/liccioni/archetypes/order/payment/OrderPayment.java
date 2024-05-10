package net.liccioni.archetypes.order.payment;

import lombok.Builder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.Currency;
import net.liccioni.archetypes.money.payment.Payment;
import net.liccioni.archetypes.money.payment.PaymentMethod;
import net.liccioni.archetypes.money.payment.PaymentRecord;
import net.liccioni.archetypes.quantity.Quantity;

import java.math.BigDecimal;

@Builder(builderMethodName = "orderPaymentBuilder", toBuilder = true)
public record OrderPayment(PaymentRecord payment) implements Payment {
    @Override
    public Currency currency() {
        return payment.currency();
    }

    @Override
    public TimeDate dateMade() {
        return payment.dateMade();
    }

    @Override
    public TimeDate dateReceived() {
        return payment.dateReceived();
    }

    @Override
    public TimeDate dateDue() {
        return payment.dateDue();
    }

    @Override
    public TimeDate dateCreated() {
        return payment.dateCreated();
    }

    @Override
    public PaymentMethod paymentMethod() {
        return payment.paymentMethod();
    }

    @Override
    public BigDecimal amount() {
        return payment.amount();
    }

    @Override
    public Quantity withAmount(BigDecimal amount) {
        return this.toBuilder().payment(payment.toBuilder().amount(amount).build()).build();
    }
}
