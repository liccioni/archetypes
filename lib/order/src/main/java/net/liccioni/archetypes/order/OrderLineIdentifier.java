package net.liccioni.archetypes.order;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.uniqueid.UniqueIdentifier;

@Builder(toBuilder = true)
public record OrderLineIdentifier(@NonNull String id) implements UniqueIdentifier {
}
