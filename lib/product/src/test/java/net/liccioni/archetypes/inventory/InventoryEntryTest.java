package net.liccioni.archetypes.inventory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import java.util.UUID;
import net.liccioni.archetypes.product.ProductIdentifier;
import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.product.SerialNumber;
import org.junit.jupiter.api.Test;

class InventoryEntryTest {

    private final ProductType p1 = ProductType.builder()
            .productIdentifier(ProductIdentifier.builder().id("p1").build())
            .name("p1").build();

    @Test
    void shouldAcceptReservation() {

        final InventoryEntry inventoryEntry = InventoryEntry.builder()
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
                .productIdentifier(p1.getProductIdentifier())
                        .numberRequested(1L)
                .build())).isTrue();
    }

    @Test
    void shouldNotAcceptReservation() {

        final InventoryEntry inventoryEntry = InventoryEntry.builder()
                .productType(p1)
                .productInstances(Set.of(
                        createInstance(p1, ReservationStatus.RESERVED),
                        createInstance(p1, ReservationStatus.RESERVED)
                ))
                .build();
        assertThat(inventoryEntry.canAcceptReservationRequest(ReservationRequest.builder()
                        .productIdentifier(p1.getProductIdentifier())
                        .numberRequested(2L)
                .build())).isFalse();
    }

    private ProductInstance createInstance(final ProductType p1,
                                           final ReservationStatus status) {
        return ProductInstance.builder()
                .productType(p1)
                .reservationStatus(status)
                .serialNumber(SerialNumber.builder().id(UUID.randomUUID().toString()).build())
                .build();
    }
}