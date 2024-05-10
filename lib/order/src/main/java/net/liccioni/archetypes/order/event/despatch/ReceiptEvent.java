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

public record ReceiptEvent(OrderIdentifier orderIdentifier,
                           PartySignature authorization,
                           TimeDate dateAuthorized,
                           String deliveryIdentifier,
                           TimeDate date,
                           Set<ReceiptLine> receiptLines) implements OrderEvent {
    @Builder(toBuilder = true)
    public ReceiptEvent(OrderIdentifier orderIdentifier,
                        PartySignature authorization,
                        TimeDate dateAuthorized,
                        @NonNull String deliveryIdentifier,
                        @NonNull TimeDate date,
                        Set<ReceiptLine> receiptLines) {
        this.orderIdentifier = orderIdentifier;
        this.authorization = authorization;
        this.dateAuthorized = dateAuthorized;
        this.deliveryIdentifier = deliveryIdentifier;
        this.date = date;
        this.receiptLines = Optional.ofNullable(receiptLines).orElseGet(HashSet::new);
    }

    @Override
    public EventHandled process(final OrderStatus orderStatus, final Order order) {
        return orderStatus.handle(this, order);
    }
}
