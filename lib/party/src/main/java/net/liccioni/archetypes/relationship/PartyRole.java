package net.liccioni.archetypes.relationship;


import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;
import net.liccioni.archetypes.party.Party;

@Value
@Builder(toBuilder = true)
public class PartyRole {

    PartyRoleIdentifier identifier;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    Party party;
    @NonNull
    PartyRoleType type;
    @Builder.Default
    Set<AssignedResponsibility> assignedResponsibilities = new HashSet<>();

    public String getName() {
        return this.type.getName();
    }

    public String getDescription() {

        return this.type.getDescription();
    }
}
