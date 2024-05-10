package net.liccioni.archetypes.order.event.amendment;

import net.liccioni.archetypes.order.event.OrderEvent;

public interface AmendEvent extends OrderEvent {
    String reason();
}
