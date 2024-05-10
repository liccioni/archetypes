package net.liccioni.archetypes.order.event;

import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.event.lifecycle.CancelEvent;
import net.liccioni.archetypes.order.event.lifecycle.CloseEvent;
import net.liccioni.archetypes.order.event.lifecycle.OpenEvent;

import static java.lang.String.format;

public class CancelledEventHandler implements EventHandler {

    @Override
    public EventHandled handle(final CancelEvent event, final Order order) {
        throw new IllegalStateException(format("cannot cancel cancelled order %s", order));
    }

    @Override
    public EventHandled handle(final CloseEvent event, final Order order) {
        throw new IllegalStateException(format("cannot close cancelled order %s", order));
    }

    @Override
    public EventHandled handle(final OpenEvent event, final Order order) {
        throw new IllegalStateException(format("cannot open cancelled order %s", order));
    }
}
