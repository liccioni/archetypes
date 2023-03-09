package net.liccioni.archetypes.order.event.payment;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.order.OrderLineIdentifier;
import net.liccioni.archetypes.order.event.OrderEvent;
import net.liccioni.archetypes.order.payment.OrderPayment;

@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public abstract class PaymentEvent extends OrderEvent {

    private final OrderLineIdentifier orderLineIdentifier;
    private final String invoiceIdentifier;
    private final OrderPayment orderPayment;
}
