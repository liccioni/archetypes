package net.liccioni.archetypes.product;

import net.liccioni.archetypes.inventory.ReservationIdentifier;
import net.liccioni.archetypes.inventory.ReservationStatus;
import net.liccioni.archetypes.product.price.ArbitraryPrice;
import net.liccioni.archetypes.product.price.Price;

import java.util.Set;

public interface ProductInstance {
    SerialNumber serialNumber();

    ProductType productType();

    String name();

    Set<ProductFeatureInstance> features();

    Price priceAgreed();

    ArbitraryPrice priceApplied();

    Batch batch();

    ReservationIdentifier reservation();

    ReservationStatus reservationStatus();

    ProductInstance reserve(ReservationIdentifier reservationIdentifier);

    ProductInstance cancelReservation();
}
