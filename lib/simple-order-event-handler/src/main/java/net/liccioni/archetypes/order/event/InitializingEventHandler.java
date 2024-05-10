package net.liccioni.archetypes.order.event;

import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderLine;
import net.liccioni.archetypes.order.OrderLineIdentifier;
import net.liccioni.archetypes.order.OrderStatus;
import net.liccioni.archetypes.order.event.amendment.AmendOrderLineEvent;
import net.liccioni.archetypes.order.event.amendment.AmendPartySummaryEvent;
import net.liccioni.archetypes.order.event.lifecycle.CancelEvent;
import net.liccioni.archetypes.order.event.lifecycle.CloseEvent;
import net.liccioni.archetypes.order.event.lifecycle.OpenEvent;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class InitializingEventHandler implements EventHandler {
    @Override
    public EventHandled handle(final AmendOrderLineEvent event, final Order order) {
        var originalOrderLine = new AtomicReference<OrderLine>();
        if (event.newOrderLine() != null) {
            extracted(order, event.newOrderLine().orderLineIdentifier()).ifPresent(orderLine -> {
                originalOrderLine.set(orderLine);
                order.lineItems().remove(orderLine);
            });
            order.lineItems().add(event.newOrderLine());
        } else if (event.orderLineIdentifier() != null) {
            extracted(order, event.orderLineIdentifier()).ifPresent(orderLine -> {
                originalOrderLine.set(orderLine);
                order.lineItems().remove(orderLine);
            });
        }
        return new EventHandled(event.toBuilder().originalOrderLine(originalOrderLine.get()).build(), order);
    }

    private Optional<OrderLine> extracted(final Order order, final OrderLineIdentifier id) {
        return order.lineItems().stream()
                .filter(p -> p.orderLineIdentifier().equals(id))
                .findFirst();
    }

    @Override
    public EventHandled handle(final AmendPartySummaryEvent event, final Order order) {
        return event.role().handle(event, order);
    }

    @Override
    public EventHandled handle(final CancelEvent event, final Order order) {
        return new EventHandled(event, order.setStatus(OrderStatus.CANCELLED));
    }

    @Override
    public EventHandled handle(final CloseEvent event, final Order order) {
        return new EventHandled(event, order.setStatus(OrderStatus.CLOSED));
    }

    @Override
    public EventHandled handle(final OpenEvent event, final Order order) {
        return new EventHandled(event, order.setStatus(OrderStatus.OPEN));
    }
}
