package net.liccioni.archetypes.product;

import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.inventory.ReservationIdentifier;
import net.liccioni.archetypes.inventory.ReservationStatus;
import net.liccioni.archetypes.product.price.ArbitraryPrice;
import net.liccioni.archetypes.product.price.Price;

@Data
@SuperBuilder(toBuilder = true)
public class ProductInstance {

    private final SerialNumber serialNumber;
    @NonNull
    private final ProductType productType;
    @Getter(lazy = true)
    private final String name = productTypeGetName();

    private final Set<ProductFeatureInstance> features;

    private final Price priceAgreed;
    private final ArbitraryPrice priceApplied;
    private final Batch batch;
    private ReservationIdentifier reservation;
    @Builder.Default
    private ReservationStatus reservationStatus = ReservationStatus.AVAILABLE;

    public void reserve(ReservationIdentifier reservationIdentifier) {

        this.reservation = reservationIdentifier;
        this.reservationStatus = ReservationStatus.RESERVED;
    }

    public void cancelReservation() {
        this.reservation = null;
        this.reservationStatus = ReservationStatus.AVAILABLE;
    }

    private String productTypeGetName() {
        assert productType != null;
        return productType.getName();
    }
}
