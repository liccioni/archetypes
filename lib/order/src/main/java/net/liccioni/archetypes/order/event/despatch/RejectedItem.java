package net.liccioni.archetypes.order.event.despatch;

import lombok.Builder;

@Builder(toBuilder = true)
public record RejectedItem(String reason) {

}
