package net.liccioni.archetypes.relationship;


import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.party.Party;

@Value
@Builder
public class PartyRoleConstraint {

    Class<? extends Party> typeOfParty;

    public boolean canPlayRole(Party party) {
        return typeOfParty.isInstance(party);
    }
}
