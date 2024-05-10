package net.liccioni.archetypes.order.event.amendment;

import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.event.EventHandled;

@FunctionalInterface
public interface AmendPartySummaryEventHandler {

    EventHandled handle(final AmendPartySummaryEvent event, final Order order);
}
