package net.liccioni.archetypes.order.event.amendment;

import lombok.Builder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderIdentifier;
import net.liccioni.archetypes.order.OrderStatus;
import net.liccioni.archetypes.order.event.EventHandled;
import net.liccioni.archetypes.party.PartySignature;

@Builder(toBuilder = true)
public record AmendTermsAndConditionsEvent(OrderIdentifier orderIdentifier,
                                           PartySignature authorization,
                                           TimeDate dateAuthorized,
                                           String reason,
                                           String oldTermAndConditions,
                                           String newTermAndConditions) implements AmendEvent {

    @Override
    public EventHandled process(final OrderStatus orderStatus, final Order order) {
        return orderStatus.handle(
                this.toBuilder().oldTermAndConditions(order.termsAndCondition()).build(),
                order.setTermsAndCondition(newTermAndConditions));
    }
}
