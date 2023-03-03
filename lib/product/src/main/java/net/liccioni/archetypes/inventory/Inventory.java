package net.liccioni.archetypes.inventory;

import java.util.List;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.product.ProductIdentifier;
import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.rule.RuleContext;

public interface Inventory {


    void addInventoryEntry(InventoryEntry entry);

    void removeInventoryEntry(InventoryEntry entry);

    List<InventoryEntry> getInventoryEntries();

    List<InventoryEntry> findInventoryEntries(ProductIdentifier identifier);

    List<ProductType> getProductTypes();

    Reservation makeReservation(ReservationRequest request);

    Reservation cancelReservation(ReservationIdentifier identifier, RuleContext cancellationContext);

    List<Reservation> getReservations();

    ReservationRequest findReservation(ReservationIdentifier identifier);

    List<Reservation> findReservationByDateReceivedAndRequesterName(TimeDate start, TimeDate end, String requesterName);

}
