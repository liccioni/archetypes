package net.liccioni.archetypes.product;

import java.util.Set;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.inventory.ReservationIdentifier;
import net.liccioni.archetypes.inventory.ReservationStatus;
import net.liccioni.archetypes.product.price.ArbitraryPrice;
import net.liccioni.archetypes.product.price.Price;

@Data
@SuperBuilder(toBuilder = true)
public class ProductInstance {

    private SerialNumber serialNumber;
    private ProductType productType;
    private String name;
    private Set<ProductFeatureInstance> features;
    private Price agreed;
    private ArbitraryPrice applied;
    private Batch batch;
    private ReservationIdentifier reservation;
    private ReservationStatus reservationStatus;

    /**
     * @generated
     */
    public boolean reserve(ReservationIdentifier reservationIdentifier) {
        //TODO
        return false;
    }

    /**
     * @generated
     */
    public boolean cancelReservation() {
        //TODO
        return false;
    }
}
