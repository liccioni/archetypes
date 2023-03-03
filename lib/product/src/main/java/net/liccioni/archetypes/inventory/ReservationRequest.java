package net.liccioni.archetypes.inventory;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class ReservationRequest {

    ReservationIdentifier reservationIdentifier;
    @Builder.Default
    Set<PartySummary> requesters = new HashSet<>();
    @Builder.Default
    Set<PartySummary> receivers = new HashSet<>();
}
