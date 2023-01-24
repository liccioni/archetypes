package net.liccioni.archetypes.order.event;


/**
* @generated
*/
public class DespatchLine {
    
    /**
    * @generated
    */
    private OrderLineIdentifier orderLineIdentifier;
    
    /**
    * @generated
    */
    private int numberDespatched;
    
    
    /**
    * @generated
    */
    private RejectedItem rejectedItems;
    
    

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
    public int getNumberDespatched() {
        return this.numberDespatched;
    }
    
    /**
    * @generated
    */
    public void setNumberDespatched(int numberDespatched) {
        this.numberDespatched = numberDespatched;
    }
    
    
    
    /**
    * @generated
    */
    public RejectedItem getRejectedItems() {
        return this.rejectedItems;
    }
    
    /**
    * @generated
    */
    public void setRejectedItems(RejectedItem rejectedItems) {
        this.rejectedItems = rejectedItems;
    }
    
    
    
}
