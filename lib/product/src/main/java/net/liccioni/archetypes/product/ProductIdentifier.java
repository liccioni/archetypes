package net.liccioni.archetypes.product;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.uniqueid.UniqueIdentifier;

@Builder(toBuilder = true)
public record ProductIdentifier(@NonNull String id) implements UniqueIdentifier {
}
