package net.liccioni.archetypes.relationship;


import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import net.liccioni.archetypes.party.Party;

@Value
@Builder(toBuilder = true)
public class PartyRoleConstraint {

    @NonNull
    Class<? extends Party> typeOfParty;

    public boolean canPlayRole(Party party) {
        return typeOfParty.isInstance(party);
    }
}
