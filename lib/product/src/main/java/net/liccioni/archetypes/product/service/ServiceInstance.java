package net.liccioni.archetypes.product.service;


import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.inventory.ReservationIdentifier;
import net.liccioni.archetypes.inventory.ReservationStatus;
import net.liccioni.archetypes.product.*;
import net.liccioni.archetypes.product.price.ArbitraryPrice;
import net.liccioni.archetypes.product.price.Price;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record ServiceInstance(SerialNumber serialNumber,
                              @NonNull ProductType productType,
                              String name,
                              Set<ProductFeatureInstance> features,
                              Price priceAgreed,
                              ArbitraryPrice priceApplied,
                              Batch batch,
                              ReservationIdentifier reservation,
                              ReservationStatus reservationStatus,
                              TimeDate start,
                              TimeDate end,
                              TimeDate scheduledStart,
                              TimeDate scheduledEnd,
                              ServiceDeliveryStatus serviceDeliverStatus
) implements ProductInstance {

    @Builder(toBuilder = true)
    public ServiceInstance(SerialNumber serialNumber,
                           @NonNull ProductType productType,
                           String name,
                           Set<ProductFeatureInstance> features,
                           Price priceAgreed,
                           ArbitraryPrice priceApplied,
                           Batch batch,
                           ReservationIdentifier reservation,
                           ReservationStatus reservationStatus,
                           TimeDate start,
                           TimeDate end,
                           TimeDate scheduledStart,
                           TimeDate scheduledEnd,
                           ServiceDeliveryStatus serviceDeliverStatus) {
        this.serialNumber = serialNumber;
        this.productType = productType;
        this.name = Optional.ofNullable(name).orElseGet(productType::name);
        this.features = Optional.ofNullable(features).orElseGet(HashSet::new);
        this.priceAgreed = priceAgreed;
        this.priceApplied = priceApplied;
        this.batch = batch;
        this.reservation = reservation;
        this.reservationStatus = Optional.ofNullable(reservationStatus).orElse(ReservationStatus.AVAILABLE);
        this.start = start;
        this.end = end;
        this.scheduledStart = scheduledStart;
        this.scheduledEnd = scheduledEnd;
        this.serviceDeliverStatus = serviceDeliverStatus;
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
