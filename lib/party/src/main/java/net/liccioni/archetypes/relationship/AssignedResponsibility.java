package net.liccioni.archetypes.relationship;


import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.party.PartySignature;

@Value
@Builder(toBuilder = true)
public class AssignedResponsibility {

    TimeDate from;
    TimeDate to;
    PartySignature partySignature;
    Responsibility responsibility;

    public String getName(){
        return this.responsibility.getName();
    }

    public String getDescription(){
        return this.responsibility.getDescription();
    }
}
