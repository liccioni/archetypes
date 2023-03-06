package net.liccioni.archetypes.order.event.payment;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.order.Order;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class InvoiceEvent extends PaymentEvent {

    @Override
    protected void internalProcess(final Order order) {

    }
}
