package net.liccioni.archetypes.product.measured;


import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.inventory.ReservationIdentifier;
import net.liccioni.archetypes.inventory.ReservationStatus;
import net.liccioni.archetypes.product.*;
import net.liccioni.archetypes.product.price.ArbitraryPrice;
import net.liccioni.archetypes.product.price.Price;
import net.liccioni.archetypes.quantity.Quantity;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record MeasuredProductInstance(SerialNumber serialNumber,
                                      @NonNull ProductType productType,
                                      String name,
                                      Set<ProductFeatureInstance> features,
                                      Price priceAgreed,
                                      ArbitraryPrice priceApplied,
                                      Batch batch,
                                      ReservationIdentifier reservation,
                                      ReservationStatus reservationStatus,
                                      Quantity quantity) implements ProductInstance {

    @Builder(toBuilder = true)
    public MeasuredProductInstance(SerialNumber serialNumber,
                                   @NonNull ProductType productType,
                                   String name,
                                   Set<ProductFeatureInstance> features,
                                   Price priceAgreed,
                                   ArbitraryPrice priceApplied,
                                   Batch batch,
                                   ReservationIdentifier reservation,
                                   ReservationStatus reservationStatus,
                                   Quantity quantity) {
        this.serialNumber = serialNumber;
        this.productType = productType;
        this.name = Optional.ofNullable(name).orElseGet(productType::name);
        this.features = Optional.ofNullable(features).orElseGet(HashSet::new);
        this.priceAgreed = priceAgreed;
        this.priceApplied = priceApplied;
        this.batch = batch;
        this.reservation = reservation;
        this.reservationStatus = Optional.ofNullable(reservationStatus).orElse(ReservationStatus.AVAILABLE);
        this.quantity = quantity;
    }

    @Override
    public ProductInstance reserve(ReservationIdentifier reservationIdentifier) {
        return toBuilder().reservationStatus(ReservationStatus.RESERVED).reservation(reservationIdentifier).build();
    }

    @Override
    public ProductInstance cancelReservation() {
        return toBuilder().reservationStatus(ReservationStatus.AVAILABLE).reservation(null).build();
    }
}
