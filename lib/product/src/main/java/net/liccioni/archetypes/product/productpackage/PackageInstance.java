package net.liccioni.archetypes.product.productpackage;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.inventory.ReservationIdentifier;
import net.liccioni.archetypes.inventory.ReservationStatus;
import net.liccioni.archetypes.product.*;
import net.liccioni.archetypes.product.price.ArbitraryPrice;
import net.liccioni.archetypes.product.price.Price;

import java.util.*;


@Builder(toBuilder = true)
public record PackageInstance(SerialNumber serialNumber,
                              @NonNull ProductType productType,
                              String name,
                              Set<ProductFeatureInstance> features,
                              Price priceAgreed,
                              ArbitraryPrice priceApplied,
                              Batch batch,
                              ReservationIdentifier reservation,
                              ReservationStatus reservationStatus,
                              List<ProductInstance> components) implements ProductInstance {

    @Builder(toBuilder = true)
    public PackageInstance(SerialNumber serialNumber,
                           @NonNull ProductType productType,
                           String name,
                           Set<ProductFeatureInstance> features,
                           Price priceAgreed,
                           ArbitraryPrice priceApplied,
                           Batch batch,
                           ReservationIdentifier reservation,
                           ReservationStatus reservationStatus,
                           List<ProductInstance> components) {
        this.serialNumber = serialNumber;
        this.productType = productType;
        this.name = Optional.ofNullable(name).orElseGet(productType::name);
        this.features = Optional.ofNullable(features).orElseGet(HashSet::new);
        this.priceAgreed = priceAgreed;
        this.priceApplied = priceApplied;
        this.batch = batch;
        this.reservation = reservation;
        this.reservationStatus = Optional.ofNullable(reservationStatus).orElse(ReservationStatus.AVAILABLE);
        this.components = Optional.ofNullable(components).orElseGet(ArrayList::new);
    }

    @Override
    public ProductInstance reserve(ReservationIdentifier reservationIdentifier) {
        return toBuilder()
                .reservation(reservationIdentifier)
                .reservationStatus(ReservationStatus.RESERVED).build();
    }

    @Override
    public ProductInstance cancelReservation() {
        return toBuilder()
                .reservation(null)
                .reservationStatus(ReservationStatus.AVAILABLE).build();
    }
}
