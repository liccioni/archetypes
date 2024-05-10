package net.liccioni.archetypes.order.event.despatch;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.order.OrderLineIdentifier;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record ReceiptLine(OrderLineIdentifier orderLineIdentifier,
                          Integer numberReceived, Boolean isAssessed,
                          Set<RejectedItem> rejectedItems) {

    @Builder(toBuilder = true)
    public ReceiptLine(@NonNull OrderLineIdentifier orderLineIdentifier,
                       Integer numberReceived,
                       Boolean isAssessed,
                       Set<RejectedItem> rejectedItems) {
        this.orderLineIdentifier = orderLineIdentifier;
        this.numberReceived = numberReceived;
        this.isAssessed = isAssessed;
        this.rejectedItems = Optional.ofNullable(rejectedItems).orElseGet(HashSet::new);
    }
}
