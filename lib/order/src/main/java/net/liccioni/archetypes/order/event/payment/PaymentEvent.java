package net.liccioni.archetypes.order.event.payment;


import net.liccioni.archetypes.order.OrderLineIdentifier;
import net.liccioni.archetypes.order.event.OrderEvent;
import net.liccioni.archetypes.order.payment.OrderPayment;

public interface PaymentEvent extends OrderEvent {

    OrderLineIdentifier orderLineIdentifier();

    String invoiceIdentifier();

    OrderPayment orderPayment();
}
