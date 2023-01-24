package net.liccioni.archetypes.order;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public abstract class OrderManager {
    
    
    /**
    * @generated
    */
    private SalesTaxPolicy salesTaxPolicies;
    
    /**
    * @generated
    */
    private Set<Order> orders;
    
    /**
    * @generated
    */
    private Set<DiscountType> discounts;
    
    

    
    /**
    * @generated
    */
    public Set<Order> getOrders() {
        if (this.orders == null) {
            this.orders = new HashSet<Order>();
        }
        return this.orders;
    }
    
    /**
    * @generated
    */
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
    
    
    /**
    * @generated
    */
    public Set<DiscountType> getDiscounts() {
        if (this.discounts == null) {
            this.discounts = new HashSet<DiscountType>();
        }
        return this.discounts;
    }
    
    /**
    * @generated
    */
    public void setDiscounts(Set<DiscountType> discounts) {
        this.discounts = discounts;
    }
    
    
    /**
    * @generated
    */
    public SalesTaxPolicy getSalesTaxPolicies() {
        return this.salesTaxPolicies;
    }
    
    /**
    * @generated
    */
    public void setSalesTaxPolicies(SalesTaxPolicy salesTaxPolicies) {
        this.salesTaxPolicies = salesTaxPolicies;
    }
    
    
    
}
