package net.liccioni.archetypes.order.event;


import net.liccioni.archetypes.order.OrderLineIdentifier;
import net.liccioni.archetypes.order.payment.OrderPayment;

/**
 * @generated
 */
public class PaymentEvent extends OrderEvent {

    /**
     * @generated
     */
    private OrderLineIdentifier orderLineIdentifier;

    /**
     * @generated
     */
    private String invoiceIdentifier;


    /**
     * @generated
     */
    private OrderPayment orderPayment;


    /**
     * @generated
     */
    public OrderLineIdentifier getOrderLineIdentifier() {
        return this.orderLineIdentifier;
    }

    /**
     * @generated
     */
    public void setOrderLineIdentifier(OrderLineIdentifier orderLineIdentifier) {
        this.orderLineIdentifier = orderLineIdentifier;
    }


    /**
     * @generated
     */
    public String getInvoiceIdentifier() {
        return this.invoiceIdentifier;
    }

    /**
     * @generated
     */
    public void setInvoiceIdentifier(String invoiceIdentifier) {
        this.invoiceIdentifier = invoiceIdentifier;
    }

    /**
     * @generated
     */
    public OrderPayment getOrderPayment() {
        return this.orderPayment;
    }

    /**
     * @generated
     */
    public void setOrderPayment(OrderPayment orderPayment) {
        this.orderPayment = orderPayment;
    }


}
