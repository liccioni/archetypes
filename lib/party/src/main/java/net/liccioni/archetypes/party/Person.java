package net.liccioni.archetypes.party;


import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.address.AddressProperties;
import net.liccioni.archetypes.preference.Preference;
import net.liccioni.archetypes.relationship.Capabilities;
import net.liccioni.archetypes.relationship.PartyRole;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record Person(PartyIdentifier identifier,
                     Capabilities capabilities,
                     Set<Preference> preferences,
                     Set<PartyAuthentication> authentications,
                     Set<RegisteredIdentifier> registeredIdentifier,
                     Set<AddressProperties> addressProperties,
                     Set<PartyRole> roles,
                     PersonName personName) implements Party {

    @Builder(toBuilder = true)
    public Person(PartyIdentifier identifier,
                  Capabilities capabilities,
                  Set<Preference> preferences,
                  Set<PartyAuthentication> authentications,
                  Set<RegisteredIdentifier> registeredIdentifier,
                  Set<AddressProperties> addressProperties,
                  Set<PartyRole> roles,
                  @NonNull PersonName personName) {
        this.identifier = identifier;
        this.capabilities = capabilities;
        this.preferences = Optional.ofNullable(preferences).orElseGet(HashSet::new);
        this.authentications = Optional.ofNullable(authentications).orElseGet(HashSet::new);
        this.registeredIdentifier = Optional.ofNullable(registeredIdentifier).orElseGet(HashSet::new);
        this.addressProperties = Optional.ofNullable(addressProperties).orElseGet(HashSet::new);
        this.roles = Optional.ofNullable(roles).orElseGet(HashSet::new);
        this.personName = personName;
    }

    @Override
    public String getName() {
        return personName.givenName().concat(",").concat(personName.familyName());
    }
}
