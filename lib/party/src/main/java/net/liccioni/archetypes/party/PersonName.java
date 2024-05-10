package net.liccioni.archetypes.party;


import lombok.Builder;
import net.liccioni.archetypes.common.TimeDate;

@Builder(toBuilder = true)
public record PersonName(String familyName,
                         String givenName,
                         TimeDate validFrom,
                         TimeDate validTo) {
}
