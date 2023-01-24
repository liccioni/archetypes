package net.liccioni.archetypes.order;


/**
* @generated
*/
public class SalesOrder extends Order {

  /**
    * @generated
    */
    private TimeDate datePurchaseOrderReceived;
  /**
    * @generated
    */
    private String customerOrderPurchaseReference;

  /**
    * @generated
    */
    public TimeDate getDatePurchaseOrderReceived() {
        return this.datePurchaseOrderReceived;
    }

  /**
    * @generated
    */
    public void setDatePurchaseOrderReceived(TimeDate datePurchaseOrderReceived) {
        this.datePurchaseOrderReceived = datePurchaseOrderReceived;
    }

  /**
    * @generated
    */
    public String getCustomerOrderPurchaseReference() {
        return this.customerOrderPurchaseReference;
    }

  /**
    * @generated
    */
    public void setCustomerOrderPurchaseReference(String customerOrderPurchaseReference) {
        this.customerOrderPurchaseReference = customerOrderPurchaseReference;
    }

  /**
    * @generated
    */
    public boolean processDespatchEvent()
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
    public boolean processAcceptPaymentEvent()
    {
        //TODO
        return false;
    }

  /**
    * @generated
    */
    public boolean processMakeRefundEvent()
    {
        //TODO
        return false;
    }
    
    
    

    
    
}
