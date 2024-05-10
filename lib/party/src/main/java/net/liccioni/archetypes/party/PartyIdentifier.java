package net.liccioni.archetypes.party;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.uniqueid.UniqueIdentifier;

@Builder(toBuilder = true)
public record PartyIdentifier(@NonNull String id) implements UniqueIdentifier {
}
