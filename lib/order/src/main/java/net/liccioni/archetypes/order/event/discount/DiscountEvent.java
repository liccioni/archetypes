package net.liccioni.archetypes.order.event.discount;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.event.OrderEvent;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class DiscountEvent extends OrderEvent {

    Boolean add;

    @Override
    protected void internalProcess(final Order order) {

    }
}
