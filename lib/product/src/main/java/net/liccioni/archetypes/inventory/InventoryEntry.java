package net.liccioni.archetypes.inventory;

import java.util.HashSet;
import java.util.Set;
import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.rule.RuleSet;

/**
 * @generated
 */
public class InventoryEntry {

    /**
     * @generated
     */
    private RuleSet availabilityPolicy;


    /**
     * @generated
     */
    private ProductType productType;

    /**
     * @generated
     */
    private Set<ProductInstance> productInstances;


    /**
     * @generated
     */
    public RuleSet getAvailabilityPolicy() {
        return this.availabilityPolicy;
    }

    /**
     * @generated
     */
    public void setAvailabilityPolicy(RuleSet availabilityPolicy) {
        this.availabilityPolicy = availabilityPolicy;
    }


    /**
     * @generated
     */
    public ProductType getProductType() {
        return this.productType;
    }

    /**
     * @generated
     */
    public void setProductType(ProductType productType) {
        this.productType = productType;
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
    public boolean addProductInstance(ProductInstance productInstance) {
        //TODO
        return false;
    }


    /**
     * @generated
     */
    public int getNumberAvailable() {
        //TODO
        return 0;
    }


    /**
     * @generated
     */
    public int getNumberReserved() {
        //TODO
        return 0;
    }


    /**
     * @generated
     */
    public boolean canAcceptReservationRequest(ReservationRequest request) {
        //TODO
        return false;
    }


    /**
     * @generated
     */
    public boolean removeProductInstance(ProductInstance productInstance) {
        //TODO
        return false;
    }


}
