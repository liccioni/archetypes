package net.liccioni.archetypes.inventory;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Reservation {

    ReservationRequest request;
}
