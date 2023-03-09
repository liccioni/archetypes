package net.liccioni.archetypes.order.payment;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.Currency;
import net.liccioni.archetypes.money.payment.Payment;
import net.liccioni.archetypes.money.payment.PaymentMethod;

@Value
@EqualsAndHashCode(callSuper = true)
public class OrderPayment extends Payment {

    String toAccount;
    String fromAccount;

    @Builder(builderMethodName = "orderPaymentBuilder")
    public OrderPayment(final Number amount, final Currency currency,
                        final TimeDate dateMade,
                        final TimeDate dateReceived,
                        final TimeDate dateDue,
                        final TimeDate dateCreated,
                        final PaymentMethod paymentMethod, final String toAccount,
                        final String fromAccount) {
        super(amount, currency, dateMade, dateReceived, dateDue, dateCreated, paymentMethod);
        this.toAccount = toAccount;
        this.fromAccount = fromAccount;
    }
}
