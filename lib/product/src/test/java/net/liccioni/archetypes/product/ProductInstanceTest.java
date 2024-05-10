package net.liccioni.archetypes.product;

import static org.assertj.core.api.Assertions.assertThat;

import net.liccioni.archetypes.inventory.ReservationIdentifier;
import net.liccioni.archetypes.inventory.ReservationStatus;
import org.junit.jupiter.api.Test;

class ProductInstanceTest {

    @Test
    void shouldReserve() {
        final ProductInstance p1 = ProductInstanceRecord.builder().productType(ProductTypeRecord.builder()
                        .name("p1")
                .build()).build();
        final ReservationIdentifier reservationIdentifier = ReservationIdentifier.builder().id("1").build();
        final var reservedProduct = p1.reserve(reservationIdentifier);
        assertThat(reservedProduct.reservationStatus()).isEqualTo(ReservationStatus.RESERVED);
        assertThat(reservedProduct.reservation()).isEqualTo(reservationIdentifier);

        final var cancelledReservation = reservedProduct.cancelReservation();
        assertThat(cancelledReservation.reservationStatus()).isEqualTo(ReservationStatus.AVAILABLE);
        assertThat(cancelledReservation.reservation()).isNull();
    }
}