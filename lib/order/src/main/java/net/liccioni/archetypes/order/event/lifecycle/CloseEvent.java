package net.liccioni.archetypes.order.event.lifecycle;


import lombok.Builder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderIdentifier;
import net.liccioni.archetypes.order.OrderStatus;
import net.liccioni.archetypes.order.event.EventHandled;
import net.liccioni.archetypes.party.PartySignature;

@Builder(toBuilder = true)
public record CloseEvent(OrderIdentifier orderIdentifier,
                         PartySignature authorization,
                         TimeDate dateAuthorized) implements LifeCycleEvent {

    @Override
    public EventHandled process(final OrderStatus orderStatus, final Order order) {
        return orderStatus.handle(this, order);
    }
}
