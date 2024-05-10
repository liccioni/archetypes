package net.liccioni.archetypes.inventory;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
public record Reservation(ReservationRequest request) {
}
