package net.liccioni.archetypes.relationship;


import java.util.Set;
import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.party.Party;

@Value
@Builder
public class PartyRole {

    PartyRoleIdentifier identifier;
    Party party;
    PartyRoleType type;
    Set<AssignedResponsibility> assignedResponsibilities;

    public String getName() {
        return this.type.getName();
    }

    public String getDescription() {

        return this.type.getDescription();
    }
}
