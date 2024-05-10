package net.liccioni.archetypes.relationship;


import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.party.PartySignature;

@Builder(toBuilder = true)
public record AssignedResponsibility(TimeDate from,
                                     TimeDate to,
                                     PartySignature partySignature,
                                     @NonNull
                                     Responsibility responsibility) {

    public String getName() {
        return this.responsibility.name();
    }

    public String getDescription() {
        return this.responsibility.description();
    }
}
