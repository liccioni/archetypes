package net.liccioni.archetypes.order.event.payment;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderStatus;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class MakePaymentEvent extends PaymentEvent {


    @Override
    public void process(final OrderStatus orderStatus, final Order order) {
        orderStatus.handle(this, order);
    }
}
