package net.liccioni.archetypes.order.event.amendment;

import net.liccioni.archetypes.order.Order;

@FunctionalInterface
public interface AmendPartySummaryEventHandler {

    void handle(final AmendPartySummaryEvent event, final Order order);
}
