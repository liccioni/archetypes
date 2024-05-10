package net.liccioni.archetypes.party;


import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.common.TimeDate;

@Builder(toBuilder = true)
public record RegisteredIdentifier(@NonNull
                                   String identifier,
                                   TimeDate validFrom,
                                   TimeDate validTo,
                                   String registrationAuthority) {
}
