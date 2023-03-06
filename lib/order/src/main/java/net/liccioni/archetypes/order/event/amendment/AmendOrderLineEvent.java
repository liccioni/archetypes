package net.liccioni.archetypes.order.event.amendment;


import java.util.Optional;
import java.util.function.Consumer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderLine;
import net.liccioni.archetypes.order.OrderLineIdentifier;

@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class AmendOrderLineEvent extends AmendEvent {

    private final OrderLineIdentifier orderLineIdentifier;
    private final OrderLine newOrderLine;
    private OrderLine originalOrderLine;

    @Override
    protected void internalProcess(final Order order) {
        if(newOrderLine != null){
            extracted(order, newOrderLine.getOrderLineIdentifier());
            order.getLineItems().add(newOrderLine);
        }else if (orderLineIdentifier != null){
            extracted(order, orderLineIdentifier);
        }
    }

    private void extracted(final Order order, final OrderLineIdentifier id) {
        order.getLineItems().stream()
                .filter(p -> p.getOrderLineIdentifier().equals(id))
                .findFirst().ifPresent(orderLine -> {
                    originalOrderLine = orderLine;
                    order.getLineItems().remove(orderLine);
                });
    }
}
