package net.liccioni.archetypes.party;

import net.liccioni.archetypes.address.AddressProperties;
import net.liccioni.archetypes.preference.Preference;
import net.liccioni.archetypes.relationship.Capabilities;
import net.liccioni.archetypes.relationship.PartyRole;

import java.util.Set;

public interface Party {

    PartyIdentifier identifier();

    Capabilities capabilities();

    Set<Preference> preferences();

    Set<PartyAuthentication> authentications();

    Set<RegisteredIdentifier> registeredIdentifier();

    Set<AddressProperties> addressProperties();

    Set<PartyRole> roles();

    String getName();
}
