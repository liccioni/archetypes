package net.liccioni.archetypes.relationship;


import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.uniqueid.UniqueIdentifier;

@Builder(toBuilder = true)
public record PartyRoleIdentifier(@NonNull String id) implements UniqueIdentifier {
}
