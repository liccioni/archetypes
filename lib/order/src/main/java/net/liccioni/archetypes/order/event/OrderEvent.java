package net.liccioni.archetypes.order.event;

import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderIdentifier;
import net.liccioni.archetypes.order.OrderStatus;
import net.liccioni.archetypes.party.PartySignature;

public interface OrderEvent {
    OrderIdentifier orderIdentifier();

    PartySignature authorization();

    TimeDate dateAuthorized();

    default Order process(final Order order) {
        var eventHandled = order.status().handle(order, this);
        eventHandled.order().auditTrail().add(eventHandled.event());
        return eventHandled.order();
    }

    EventHandled process(final OrderStatus orderStatus, final Order order);
}
