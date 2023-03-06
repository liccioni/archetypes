package net.liccioni.archetypes.order.event.despatch;


import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class RejectedItem {

    String reason;
}
