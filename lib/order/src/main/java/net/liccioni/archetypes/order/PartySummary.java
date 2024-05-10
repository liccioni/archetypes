package net.liccioni.archetypes.order;


import net.liccioni.archetypes.party.PartyIdentifier;
import net.liccioni.archetypes.relationship.PartyRoleIdentifier;

public interface PartySummary {

    PartyRoleIdentifier partyRoleIdentifier();

    String name();

    String address();

    String telephoneNumber();

    String emailAddress();

    PartyIdentifier partyIdentifier();
}
