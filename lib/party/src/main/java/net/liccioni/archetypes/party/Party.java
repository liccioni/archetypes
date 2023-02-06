package net.liccioni.archetypes.party;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.address.AddressProperties;
import net.liccioni.archetypes.preference.Preference;
import net.liccioni.archetypes.relationship.Capabilities;
import net.liccioni.archetypes.relationship.PartyRole;

@Data
@SuperBuilder(toBuilder = true)
public abstract class Party {

    private final String name;
    @Builder.Default
    private final Capabilities capabilities = Capabilities.builder().name("noCapabilities").build();
    @Builder.Default
    private final Set<Preference> preferences = new HashSet<>();
    @Builder.Default
    private final Set<PartyAuthentication> authentications = new HashSet<>();
    @Builder.Default
    private final Set<RegisteredIdentifier> registeredIdentifier = new HashSet<>();
    @Builder.Default
    private final Set<AddressProperties> addressProperties = new HashSet<>();
    @Builder.Default
    private final Set<PartyRole> roles = new HashSet<>();
    private final PartyIdentifier partyIdentifier;
}
