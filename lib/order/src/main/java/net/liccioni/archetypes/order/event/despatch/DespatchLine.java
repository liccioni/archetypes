package net.liccioni.archetypes.order.event.despatch;


import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import net.liccioni.archetypes.order.OrderLineIdentifier;

@Value
@Builder(toBuilder = true)
public class DespatchLine {

    @NonNull
    OrderLineIdentifier orderLineIdentifier;
    Integer numberDespatched;
    @Builder.Default
    Set<RejectedItem> rejectedItems = new HashSet<>();
}
