package net.liccioni.archetypes.inventory;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class Inventory {
    
    
    /**
    * @generated
    */
    private Set<InventoryEntry> entries;
    
    /**
    * @generated
    */
    private Set<ProductType> productTypes;
    
    /**
    * @generated
    */
    private Set<ReservationRequest> requests;
    
    /**
    * @generated
    */
    private Set<ProductInstance> productInstances;
    
    /**
    * @generated
    */
    private Set<Reservation> reservations;
    
    

    
    /**
    * @generated
    */
    public Set<ReservationRequest> getRequests() {
        if (this.requests == null) {
            this.requests = new HashSet<ReservationRequest>();
        }
        return this.requests;
    }
    
    /**
    * @generated
    */
    public void setRequests(Set<ReservationRequest> requests) {
        this.requests = requests;
    }
    
    
    /**
    * @generated
    */
    public Set<ProductType> getProductTypes() {
        if (this.productTypes == null) {
            this.productTypes = new HashSet<ProductType>();
        }
        return this.productTypes;
    }
    
    /**
    * @generated
    */
    public void setProductTypes(Set<ProductType> productTypes) {
        this.productTypes = productTypes;
    }
    
    
    /**
    * @generated
    */
    public Set<InventoryEntry> getEntries() {
        if (this.entries == null) {
            this.entries = new HashSet<InventoryEntry>();
        }
        return this.entries;
    }
    
    /**
    * @generated
    */
    public void setEntries(Set<InventoryEntry> entries) {
        this.entries = entries;
    }
    
    
    /**
    * @generated
    */
    public Set<Reservation> getReservations() {
        if (this.reservations == null) {
            this.reservations = new HashSet<Reservation>();
        }
        return this.reservations;
    }
    
    /**
    * @generated
    */
    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    
    /**
    * @generated
    */
    public Set<ProductInstance> getProductInstances() {
        if (this.productInstances == null) {
            this.productInstances = new HashSet<ProductInstance>();
        }
        return this.productInstances;
    }
    
    /**
    * @generated
    */
    public void setProductInstances(Set<ProductInstance> productInstances) {
        this.productInstances = productInstances;
    }
    
    
    

    //                          Operations                                  
    
    
    
    /**
    * @generated
    */
    public boolean addInventoryEntry(InventoryEntry entry)
    {
        //TODO
        return false;
    }
    
    
    
    /**
    * @generated
    */
    public boolean removeInventoryEntry(InventoryEntry entry)
    {
        //TODO
        return false;
    }
    
    
    
    /**
    * @generated
    */
    public List<InventoryEntry> getInventoryEntries(InventoryEntry entry)
    {
        //TODO
        return null;
    }
    
    
    
    /**
    * @generated
    */
    public List<InventoryEntry> findInventoryEntries(ProductIdentifier identifier)
    {
        //TODO
        return null;
    }
    
    
    
    /**
    * @generated
    */
    public Reservation makeReservation(ReservationRequest request)
    {
        //TODO
        return null;
    }
    
    
    
    /**
    * @generated
    */
    public Reservation cancelReservation(ReservationIdentifier identifier, RuleContext cancellationContext)
    {
        //TODO
        return null;
    }
    
    
    
    /**
    * @generated
    */
    public ReservationRequest findReservation(ReservationIdentifier identifier)
    {
        //TODO
        return null;
    }
    
    
    
    /**
    * @generated
    */
    public List<Reservation> findReservationByDateReceivedAndRequesterName(TimeDate start, TimeDate end, String requesterName)
    {
        //TODO
        return null;
    }
    
    
}
