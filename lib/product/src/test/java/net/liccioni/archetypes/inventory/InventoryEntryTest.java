package net.liccioni.archetypes.inventory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import java.util.UUID;
import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.product.SerialNumber;
import org.junit.jupiter.api.Test;

class InventoryEntryTest {

    @Test
    void shouldAcceptReservation() {
        final ProductType p1 = ProductType.builder().name("p1").build();
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
        assertThat(inventoryEntry.canAcceptReservationRequest(ReservationRequest.builder().build())).isTrue();
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