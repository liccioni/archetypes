package net.liccioni.archetypes.order;


/**
* @generated
*/
public class PurchaseOrder extends Order {

  /**
    * @generated
    */
    private TimeDate dateSent;

  /**
    * @generated
    */
    public TimeDate getDateSent() {
        return this.dateSent;
    }

  /**
    * @generated
    */
    public void setDateSent(TimeDate dateSent) {
        this.dateSent = dateSent;
    }

  /**
    * @generated
    */
    public boolean processReceiptEvent()
    {
        //TODO
        return false;
    }

  /**
    * @generated
    */
    public boolean processInvoiceEvent()
    {
        //TODO
        return false;
    }

  /**
    * @generated
    */
    public boolean processMakePaymentEvent()
    {
        //TODO
        return false;
    }

  /**
    * @generated
    */
    public boolean processAcceptRefundEvent()
    {
        //TODO
        return false;
    }
    
    
    

    
    
}
