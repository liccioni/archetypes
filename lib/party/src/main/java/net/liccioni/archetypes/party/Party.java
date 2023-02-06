package net.liccioni.archetypes.party;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.address.AddressProperties;
import net.liccioni.archetypes.preference.Preference;
import net.liccioni.archetypes.relationship.Capabilities;
import net.liccioni.archetypes.relationship.PartyRole;

@Data
@SuperBuilder
public abstract class Party {

    private final String name;
    private final Capabilities capabilities;
    private final Set<Preference> preferences = new HashSet<>();
    private final Set<PartyAuthentication> authentications;
    private final Set<RegisteredIdentifier> registeredIdentifier;
    private final Set<AddressProperties> addressProperties;
    private final Set<PartyRole> roles;
    private final PartyIdentifier partyIdentifier;
}
