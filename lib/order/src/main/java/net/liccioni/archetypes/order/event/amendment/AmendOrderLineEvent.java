package net.liccioni.archetypes.order.event.amendment;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderLine;
import net.liccioni.archetypes.order.OrderLineIdentifier;
import net.liccioni.archetypes.order.OrderStatus;

@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class AmendOrderLineEvent extends AmendEvent {

    private final OrderLineIdentifier orderLineIdentifier;
    private final OrderLine newOrderLine;
    private OrderLine originalOrderLine;

    @Override
    public void process(final OrderStatus orderStatus, final Order order) {
        orderStatus.handle(this, order);
    }
}
