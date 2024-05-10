package net.liccioni.archetypes.relationship;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.party.Party;

@Builder(toBuilder = true)
public record PartyRoleConstraint(@NonNull Class<? extends Party> typeOfParty) {

    public boolean canPlayRole(Party party) {
        return typeOfParty.isInstance(party);
    }
}
