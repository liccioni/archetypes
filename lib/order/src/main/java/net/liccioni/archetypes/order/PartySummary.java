package net.liccioni.archetypes.order;


import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.party.PartyIdentifier;
import net.liccioni.archetypes.relationship.PartyRoleIdentifier;

@Data
@SuperBuilder(toBuilder = true)
public class PartySummary {

    private final PartyRoleIdentifier partyRoleIdentifier;
    private final String name;
    private final String address;
    private final String telephoneNumber;
    private final String emailAddress;
    private final PartyIdentifier partyIdentifier;
}
