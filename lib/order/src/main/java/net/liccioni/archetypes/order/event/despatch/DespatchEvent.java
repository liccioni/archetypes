package net.liccioni.archetypes.order.event.despatch;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderIdentifier;
import net.liccioni.archetypes.order.OrderStatus;
import net.liccioni.archetypes.order.event.EventHandled;
import net.liccioni.archetypes.order.event.OrderEvent;
import net.liccioni.archetypes.party.PartySignature;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record DespatchEvent(OrderIdentifier orderIdentifier,
                            PartySignature authorization,
                            TimeDate dateAuthorized,
                            Boolean processed,
                            String despatchIdentifier,
                            TimeDate date,
                            Set<String> shippingInstructions,
                            Set<DespatchLine> despatchLines) implements OrderEvent {

    @Builder(toBuilder = true)
    public DespatchEvent(OrderIdentifier orderIdentifier,
                         PartySignature authorization,
                         TimeDate dateAuthorized,
                         Boolean processed,
                         @NonNull String despatchIdentifier,
                         @NonNull TimeDate date,
                         Set<String> shippingInstructions,
                         Set<DespatchLine> despatchLines) {
        this.orderIdentifier = orderIdentifier;
        this.authorization = authorization;
        this.dateAuthorized = dateAuthorized;
        this.processed = Optional.ofNullable(processed).orElse(false);
        this.despatchIdentifier = despatchIdentifier;
        this.date = date;
        this.shippingInstructions = Optional.ofNullable(shippingInstructions).orElseGet(HashSet::new);
        this.despatchLines = Optional.ofNullable(despatchLines).orElseGet(HashSet::new);
    }

    @Override
    public EventHandled process(final OrderStatus orderStatus, final Order order) {
        return orderStatus.handle(this, order);
    }
}
