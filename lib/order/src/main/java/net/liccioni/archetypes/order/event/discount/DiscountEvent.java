package net.liccioni.archetypes.order.event.discount;

import lombok.Builder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderIdentifier;
import net.liccioni.archetypes.order.OrderStatus;
import net.liccioni.archetypes.order.discount.Discount;
import net.liccioni.archetypes.order.event.EventHandled;
import net.liccioni.archetypes.order.event.OrderEvent;
import net.liccioni.archetypes.party.PartySignature;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record DiscountEvent(OrderIdentifier orderIdentifier,
                            PartySignature authorization,
                            TimeDate dateAuthorized,
                            Boolean add,
                            Set<Discount> discounts) implements OrderEvent {

    @Builder(toBuilder = true)
    public DiscountEvent(OrderIdentifier orderIdentifier,
                         PartySignature authorization,
                         TimeDate dateAuthorized,
                         Boolean add,
                         Set<Discount> discounts) {
        this.orderIdentifier = orderIdentifier;
        this.authorization = authorization;
        this.dateAuthorized = dateAuthorized;
        this.add = add;
        this.discounts = Optional.ofNullable(discounts).orElseGet(HashSet::new);
    }

    @Override
    public EventHandled process(final OrderStatus orderStatus, final Order order) {
        return orderStatus.handle(this, order);
    }
}
