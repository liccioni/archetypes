package net.liccioni.archetypes.inventory;


import lombok.Builder;
import net.liccioni.archetypes.party.PartyIdentifier;
import net.liccioni.archetypes.relationship.PartyRoleIdentifier;

@Builder(toBuilder = true)
public record PartySummary(PartyIdentifier partyIdentifier,
                           PartyRoleIdentifier partyRoleIdentifier,
                           String name,
                           String address,
                           String telephoneNumber,
                           String emailAddress,
                           ReservationRequest reservationRequest) {
}
