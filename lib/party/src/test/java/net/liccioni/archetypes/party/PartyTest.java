package net.liccioni.archetypes.party;

import static net.liccioni.archetypes.quantity.SIBaseUnit.METRE;
import static org.assertj.core.api.Assertions.assertThat;

import net.liccioni.archetypes.preference.Preference;
import net.liccioni.archetypes.preference.PreferenceOption;
import net.liccioni.archetypes.preference.PreferenceType;
import net.liccioni.archetypes.quantity.Quantity;
import net.liccioni.archetypes.uniqueid.UniqueIdentifier;
import org.junit.jupiter.api.Test;

class PartyTest {

    @Test
    void shouldCreateAPerson() {
        final Person gus = Person.builder()
                .partyIdentifier(PartyIdentifier.builder().id("1").build())
                .personName(PersonName.builder().familyName("Rodriguez").build()).build();

        final Person gus2 = Person.builder()
                .partyIdentifier(PartyIdentifier.builder().id("1").build())
                .personName(PersonName.builder().familyName("Rodriguez").build()).build();

        final Person gus3 = Person.builder()
                .partyIdentifier(PartyIdentifier.builder().id("1").build())
                .personName(PersonName.builder().familyName("Rodriguez").build()).build();
        gus3.getPreferences()
                .add(Preference.builder()
                        .option(PreferenceOption.builder().name("email").build())
                        .preferenceWeight(new Quantity(1, METRE))
                        .preferenceType(PreferenceType.builder()
                                .id(UniqueIdentifier.builder().id("2").build())
                                .name("Communication")
                                .build())
                        .build());

        final Person dora = Person.builder()
                .partyIdentifier(PartyIdentifier.builder().id("2").build())
                .personName(PersonName.builder().familyName("Angelov").build()).build();

        assertThat(gus).isNotEqualTo(dora);
        assertThat(gus).isEqualTo(gus2);
        assertThat(gus).isNotEqualTo(gus3);
    }
}