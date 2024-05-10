package net.liccioni.archetypes.inventory;

import net.liccioni.archetypes.product.*;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class InventoryEntryTest {

    private final ProductType p1 = ProductTypeRecord.builder()
            .productIdentifier(ProductIdentifier.builder().id("p1").build())
            .name("p1").build();

    @Test
    void shouldAcceptReservation() {

        final InventoryEntry inventoryEntry = InventoryEntryRecord.builder()
                .productType(p1)
                .productInstances(Set.of(
                        createInstance(p1, ReservationStatus.AVAILABLE),
                        createInstance(p1, ReservationStatus.AVAILABLE),
                        createInstance(p1, ReservationStatus.AVAILABLE),
                        createInstance(p1, ReservationStatus.RESERVED),
                        createInstance(p1, ReservationStatus.RESERVED)
                ))
                .build();
        assertThat(inventoryEntry.getNumberAvailable()).isEqualTo(3);
        assertThat(inventoryEntry.getNumberReserved()).isEqualTo(2);
        assertThat(inventoryEntry.canAcceptReservationRequest(ReservationRequest.builder()
                .productIdentifier(p1.productIdentifier())
                .numberRequested(1L)
                .build())).isTrue();
    }

    @Test
    void shouldNotAcceptReservation() {

        final InventoryEntry inventoryEntry = InventoryEntryRecord.builder()
                .productType(p1)
                .productInstances(Set.of(
                        createInstance(p1, ReservationStatus.RESERVED),
                        createInstance(p1, ReservationStatus.RESERVED)
                ))
                .build();
        assertThat(inventoryEntry.canAcceptReservationRequest(ReservationRequest.builder()
                .productIdentifier(p1.productIdentifier())
                .numberRequested(2L)
                .build())).isFalse();
    }

    private ProductInstance createInstance(final ProductType p1,
                                           final ReservationStatus status) {
        return ProductInstanceRecord.builder()
                .productType(p1)
                .reservationStatus(status)
                .serialNumber(SerialNumber.builder().id(UUID.randomUUID().toString()).build())
                .build();
    }
}