package net.liccioni.archetypes.inventory;


import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.uniqueid.UniqueIdentifier;

@Builder(toBuilder = true)
public record ReservationIdentifier(@NonNull String id) implements UniqueIdentifier {
}
