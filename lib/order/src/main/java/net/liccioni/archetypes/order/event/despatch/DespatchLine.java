package net.liccioni.archetypes.order.event.despatch;


import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.order.OrderLineIdentifier;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record DespatchLine(OrderLineIdentifier orderLineIdentifier,
                           Integer numberDespatched,
                           Set<RejectedItem> rejectedItems) {
    @Builder(toBuilder = true)
    public DespatchLine(@NonNull OrderLineIdentifier orderLineIdentifier,
                        Integer numberDespatched,
                        Set<RejectedItem> rejectedItems) {
        this.orderLineIdentifier = orderLineIdentifier;
        this.numberDespatched = numberDespatched;
        this.rejectedItems = Optional.ofNullable(rejectedItems).orElseGet(HashSet::new);
    }
}
