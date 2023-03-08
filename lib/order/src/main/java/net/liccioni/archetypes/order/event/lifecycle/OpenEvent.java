package net.liccioni.archetypes.order.event.lifecycle;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderStatus;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class OpenEvent extends LifeCycleEvent {

    @Override
    public void process(final OrderStatus orderStatus, final Order order) {
        orderStatus.handle(this, order);
    }
}
