package net.liccioni.archetypes.order.event.despatch;


import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.order.OrderLineIdentifier;

@Value
@Builder(toBuilder = true)
public class ReceiptLine {

    OrderLineIdentifier orderLineIdentifier;
    Integer numberReceived;
    Boolean isAssessed;
    RejectedItem rejectedItems;
}
