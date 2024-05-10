package net.liccioni.archetypes.party;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.common.TimeDate;

@Builder(toBuilder = true)
public record OrganizationName(@NonNull
                               String name,
                               String use,
                               TimeDate validFrom,
                               TimeDate validTo) {
}
