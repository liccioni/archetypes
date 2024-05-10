package net.liccioni.archetypes.order.event;

import static java.lang.String.format;

import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.event.lifecycle.OpenEvent;

public class OpenEventHandler extends InitializingEventHandler {

    @Override
    public EventHandled handle(final OpenEvent event, final Order order) {
        throw new IllegalStateException(format("cannot reopen opened order %s", order));
    }
}
