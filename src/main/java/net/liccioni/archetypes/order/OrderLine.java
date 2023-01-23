package net.liccioni.archetypes.order;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class OrderLine {
    
    
    /**
    * @generated
    */
    private ChargeLine chargeLine;
    
    /**
    * @generated
    */
    private OrderLineIdentifier orderLineIdentifier;
    
    /**
    * @generated
    */
    private Set<TaxOnLine> taxes;
    
    /**
    * @generated
    */
    private DeliveryReceiver orderLineReceiver;
    
    

    
    /**
    * @generated
    */
    public DeliveryReceiver getOrderLineReceiver() {
        return this.orderLineReceiver;
    }
    
    /**
    * @generated
    */
    public void setOrderLineReceiver(DeliveryReceiver orderLineReceiver) {
        this.orderLineReceiver = orderLineReceiver;
    }
    
    
    /**
    * @generated
    */
    public Set<TaxOnLine> getTaxes() {
        if (this.taxes == null) {
            this.taxes = new HashSet<TaxOnLine>();
        }
        return this.taxes;
    }
    
    /**
    * @generated
    */
    public void setTaxes(Set<TaxOnLine> taxes) {
        this.taxes = taxes;
    }
    
    
    /**
    * @generated
    */
    public OrderLineIdentifier getOrderLineIdentifier() {
        return this.orderLineIdentifier;
    }
    
    /**
    * @generated
    */
    public void setOrderLineIdentifier(OrderLineIdentifier orderLineIdentifier) {
        this.orderLineIdentifier = orderLineIdentifier;
    }
    
    
    /**
    * @generated
    */
    public ChargeLine getChargeLine() {
        return this.chargeLine;
    }
    
    /**
    * @generated
    */
    public void setChargeLine(ChargeLine chargeLine) {
        this.chargeLine = chargeLine;
    }
    
    
    
}
