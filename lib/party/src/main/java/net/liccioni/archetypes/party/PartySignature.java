package net.liccioni.archetypes.party;

import lombok.Builder;
import net.liccioni.archetypes.common.TimeDate;

@Builder(toBuilder = true)
public record PartySignature(TimeDate when,
                             String reason,
                             PartyAuthentication authentication,
                             PartyIdentifier partyIdentifier) {


}
