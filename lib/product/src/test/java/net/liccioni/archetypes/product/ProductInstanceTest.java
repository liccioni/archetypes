package net.liccioni.archetypes.product;

import static org.assertj.core.api.Assertions.assertThat;

import net.liccioni.archetypes.inventory.ReservationIdentifier;
import net.liccioni.archetypes.inventory.ReservationStatus;
import org.junit.jupiter.api.Test;

class ProductInstanceTest {

    @Test
    void shouldReserve() {
        final ProductInstance p1 = ProductInstance.builder().build();
        final ReservationIdentifier reservationIdentifier = ReservationIdentifier.builder().id("1").build();
        p1.reserve(reservationIdentifier);
        assertThat(p1.getReservationStatus()).isEqualTo(ReservationStatus.RESERVED);
        assertThat(p1.getReservation()).isEqualTo(reservationIdentifier);

        p1.cancelReservation();
        assertThat(p1.getReservationStatus()).isEqualTo(ReservationStatus.AVAILABLE);
        assertThat(p1.getReservation()).isNull();
    }
}