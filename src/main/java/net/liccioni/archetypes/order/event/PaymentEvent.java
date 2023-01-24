package net.liccioni.archetypes.order.event;


/**
* @generated
*/
public class PaymentEvent extends OrderEvent {
    
    /**
    * @generated
    */
    private OrderLineIdentifier orderLineIdentifier;
    
    /**
    * @generated
    */
    private String invoiceIdentifier;
    
    
    

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
    public String getInvoiceIdentifier() {
        return this.invoiceIdentifier;
    }
    
    /**
    * @generated
    */
    public void setInvoiceIdentifier(String invoiceIdentifier) {
        this.invoiceIdentifier = invoiceIdentifier;
    }
    
    
    
    
}
