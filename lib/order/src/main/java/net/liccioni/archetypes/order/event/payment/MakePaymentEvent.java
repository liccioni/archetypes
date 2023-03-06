package net.liccioni.archetypes.order.event.payment;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.event.payment.PaymentEvent;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class MakePaymentEvent extends PaymentEvent {


    @Override
    protected void internalProcess(final Order order) {

    }
}
