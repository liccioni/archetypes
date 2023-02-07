package net.liccioni.archetypes.address;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.val;
import org.junit.jupiter.api.Test;

class AddressTest {

    @Test
    void shouldCreateAddresses() {
        val myEmail = EmailAddress.builder().emailAddress("my@email.com").build();
        assertThat(myEmail.getAddress()).isEqualTo("my@email.com");
    }
}