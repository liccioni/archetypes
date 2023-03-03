package net.liccioni.archetypes.inventory;


import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.party.PartyIdentifier;
import net.liccioni.archetypes.relationship.PartyRoleIdentifier;

@Value
@Builder(toBuilder = true)
public class PartySummary {

    PartyIdentifier partyIdentifier;
    PartyRoleIdentifier partyRoleIdentifier;
    String name;
    String address;
    String telephoneNumber;
    String emailAddress;
    ReservationRequest reservationRequest;
}
