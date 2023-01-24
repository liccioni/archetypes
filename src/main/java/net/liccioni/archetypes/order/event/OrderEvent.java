package net.liccioni.archetypes.order.event;


/**
* @generated
*/
public class OrderEvent {
    
    /**
    * @generated
    */
    private OrderIdentifier orderIdentifier;
    
    /**
    * @generated
    */
    private PartySignature authorization;
    
    /**
    * @generated
    */
    private TimeDate dateAuthorized;
    
    /**
    * @generated
    */
    private boolean processed;
    
    
    

    /**
    * @generated
    */
    public OrderIdentifier getOrderIdentifier() {
        return this.orderIdentifier;
    }
    
    /**
    * @generated
    */
    public void setOrderIdentifier(OrderIdentifier orderIdentifier) {
        this.orderIdentifier = orderIdentifier;
    }
    
    
    /**
    * @generated
    */
    public PartySignature getAuthorization() {
        return this.authorization;
    }
    
    /**
    * @generated
    */
    public void setAuthorization(PartySignature authorization) {
        this.authorization = authorization;
    }
    
    
    /**
    * @generated
    */
    public TimeDate getDateAuthorized() {
        return this.dateAuthorized;
    }
    
    /**
    * @generated
    */
    public void setDateAuthorized(TimeDate dateAuthorized) {
        this.dateAuthorized = dateAuthorized;
    }
    
    
    /**
    * @generated
    */
    public boolean getProcessed() {
        return this.processed;
    }
    
    /**
    * @generated
    */
    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
    
    
    
    
}
