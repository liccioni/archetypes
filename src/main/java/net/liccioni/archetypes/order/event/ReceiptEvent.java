package net.liccioni.archetypes.order.event;


/**
* @generated
*/
public class ReceiptEvent extends OrderEvent {
    
    /**
    * @generated
    */
    private String deliveryIdentifier;
    
    /**
    * @generated
    */
    private TimeDate date;
    
    
    /**
    * @generated
    */
    private ReceiptLine receiptLines;
    
    

    /**
    * @generated
    */
    public String getDeliveryIdentifier() {
        return this.deliveryIdentifier;
    }
    
    /**
    * @generated
    */
    public void setDeliveryIdentifier(String deliveryIdentifier) {
        this.deliveryIdentifier = deliveryIdentifier;
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
    public ReceiptLine getReceiptLines() {
        return this.receiptLines;
    }
    
    /**
    * @generated
    */
    public void setReceiptLines(ReceiptLine receiptLines) {
        this.receiptLines = receiptLines;
    }
    
    
    
}
