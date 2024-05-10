package net.liccioni.archetypes.relationship;


import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.party.Party;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Builder(toBuilder = true)
public record PartyRole(PartyRoleIdentifier identifier,
                        Party party,
                        @NonNull PartyRoleType type,
                        Set<AssignedResponsibility> assignedResponsibilities) {

    /*PartyRoleIdentifier identifier;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    Party party;
    @NonNull
    PartyRoleType type;
    @Builder.Default
    Set<AssignedResponsibility> assignedResponsibilities = new HashSet<>();*/

    public PartyRole(PartyRoleIdentifier identifier,
                     Party party,
                     @NonNull PartyRoleType type,
                     Set<AssignedResponsibility> assignedResponsibilities) {
        this.identifier = identifier;
        this.party = party;
        this.type = type;
        this.assignedResponsibilities = Optional.ofNullable(assignedResponsibilities).orElseGet(HashSet::new);
    }

    public String getName() {
        return this.type.name();
    }

    public String getDescription() {
        return this.type.description();
    }
}
