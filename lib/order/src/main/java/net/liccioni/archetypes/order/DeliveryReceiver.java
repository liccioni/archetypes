package net.liccioni.archetypes.order;

import lombok.Builder;
import net.liccioni.archetypes.party.PartyIdentifier;
import net.liccioni.archetypes.relationship.PartyRoleIdentifier;

@Builder(toBuilder = true)
public record DeliveryReceiver(PartyRoleIdentifier partyRoleIdentifier,
                               String name,
                               String address,
                               String telephoneNumber,
                               String emailAddress,
                               PartyIdentifier partyIdentifier,
                               String deliveryInstructions) implements PartySummary {

}
