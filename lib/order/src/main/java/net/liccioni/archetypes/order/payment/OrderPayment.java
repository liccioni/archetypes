package net.liccioni.archetypes.order.payment;


import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.Currency;
import net.liccioni.archetypes.money.payment.Payment;
import net.liccioni.archetypes.money.payment.PaymentMethod;

/**
 * @generated
 */
public class OrderPayment extends Payment {

    /**
     * @generated
     */
    private String toAccount;

    /**
     * @generated
     */
    private String fromAccount;

    public OrderPayment(final Number amount,
                        final Currency currency,
                        final TimeDate dateMade,
                        final TimeDate dateReceived,
                        final TimeDate dateDue,
                        final TimeDate dateCreated,
                        final PaymentMethod paymentMethod) {
        super(amount, currency, dateMade, dateReceived, dateDue, dateCreated, paymentMethod);
    }


    /**
     * @generated
     */
    public String getToAccount() {
        return this.toAccount;
    }

    /**
     * @generated
     */
    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }


    /**
     * @generated
     */
    public String getFromAccount() {
        return this.fromAccount;
    }

    /**
     * @generated
     */
    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }


}
