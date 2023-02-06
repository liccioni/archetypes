package net.liccioni.archetypes.party;


import lombok.Value;
import net.liccioni.archetypes.common.TimeDate;

@Value
public class PartySignature {

    TimeDate when;
    String reason;
    PartyAuthentication authentication;
    PartyIdentifier partyIdentifier;
}
