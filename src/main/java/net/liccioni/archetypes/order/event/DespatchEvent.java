package net.liccioni.archetypes.order.event;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class DespatchEvent extends OrderEvent {
    
    /**
    * @generated
    */
    private String despatchIdentifier;
    
    /**
    * @generated
    */
    private TimeDate date;
    
    /**
    * @generated
    */
    private Set<String> shippingInstructions;
    
    
    /**
    * @generated
    */
    private DespatchLine despatchLines;
    
    

    /**
    * @generated
    */
    public String getDespatchIdentifier() {
        return this.despatchIdentifier;
    }
    
    /**
    * @generated
    */
    public void setDespatchIdentifier(String despatchIdentifier) {
        this.despatchIdentifier = despatchIdentifier;
    }
    
    
    /**
    * @generated
    */
    public TimeDate getDate() {
        return this.date;
    }
    
    /**
    * @generated
    */
    public void setDate(TimeDate date) {
        this.date = date;
    }
    
    
    /**
    * @generated
    */
    public Set<String> getShippingInstructions() {
        if (this.shippingInstructions == null) {
            this.shippingInstructions = new HashSet<String>();
        }
        return this.shippingInstructions;
    }
    
    /**
    * @generated
    */
    public void setShippingInstructions(Set<String> shippingInstructions) {
        this.shippingInstructions = shippingInstructions;
    }
    
    
    
    /**
    * @generated
    */
    public DespatchLine getDespatchLines() {
        return this.despatchLines;
    }
    
    /**
    * @generated
    */
    public void setDespatchLines(DespatchLine despatchLines) {
        this.despatchLines = despatchLines;
    }
    
    
    
}
