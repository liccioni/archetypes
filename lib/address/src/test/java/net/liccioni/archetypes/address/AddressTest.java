package net.liccioni.archetypes.address;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddressTest {

    @Test
    void shouldCreateEmailAddresses() {
        val myEmail = EmailAddress.builder().emailAddress("my@email.com").build();
        assertThat(myEmail.address()).isEqualTo("my@email.com");
    }

    @Test
    void shouldCreateTelecomAddresses() {
        val address = TelecomAddress.builder()
                .countryCode("34")
                .build();
        assertThat(address.address()).isEqualTo("+34 (null) null null ext. null");
    }

    @Test
    void shouldCreateGeographicAddresses() {
        val address = GeographicAddress.builder()
                .city("Barcelona")
                .country(ISOCountryCode.builder().identifier("ES").name("Spain").build())
                .build();
        assertThat(address.address()).isEqualTo(", Barcelona, , , Spain");
    }

    @Test
    void shouldCreateWebPageAddresses() {
        val address = WebPageAddress.builder()
                .url("my-website.com")
                .build();
        assertThat(address.address()).isEqualTo("my-website.com");
    }
}