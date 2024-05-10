package net.liccioni.archetypes.order.event.amendment;


import lombok.Builder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.*;
import net.liccioni.archetypes.order.event.EventHandled;
import net.liccioni.archetypes.party.PartySignature;

@Builder(toBuilder = true)
public record AmendOrderLineEvent(OrderIdentifier orderIdentifier,
                                  PartySignature authorization,
                                  TimeDate dateAuthorized,
                                  String reason,
                                  OrderLineIdentifier orderLineIdentifier,
                                  OrderLine newOrderLine,
                                  OrderLine originalOrderLine) implements AmendEvent {

    @Override
    public EventHandled process(final OrderStatus orderStatus, final Order order) {
        return orderStatus.handle(this, order);
    }
}
