package net.liccioni.archetypes.order.event;

import net.liccioni.archetypes.order.Order;

public record EventHandled(OrderEvent event, Order order) {
}
