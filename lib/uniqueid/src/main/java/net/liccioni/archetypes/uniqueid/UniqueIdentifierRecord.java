package net.liccioni.archetypes.uniqueid;

import lombok.Builder;
import lombok.NonNull;

@Builder(toBuilder = true)
public record UniqueIdentifierRecord(@NonNull String id) implements UniqueIdentifier {
}
