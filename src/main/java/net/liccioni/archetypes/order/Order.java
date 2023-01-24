package net.liccioni.archetypes.order;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class Order {
    
    /**
    * @generated
    */
    private OrderStatus status;
    
    
    /**
    * @generated
    */
    private TimeDate dateCreated;


    /**
    * @generated
    */
    private String salesChannel;


    /**
    * @generated
    */
    private String termsAndCondition;


    /**
    * @generated
    */
    private RuleContext discountContext;


    /**
    * @generated
    */
    private Set<OrderEvent> auditTrail;


    /**
    * @generated
    */
    private PartySummary paymentReceiver;
    
    /**
    * @generated
    */
    private Set<OrderLine> lineItems;
    
    /**
    * @generated
    */
    private OrderIdentifier orderIdentifier;
    
    /**
    * @generated
    */
    private PartySummary purchaser;
    
    /**
    * @generated
    */
    private Set<ChargeLine> chargeLines;
    
    /**
    * @generated
    */
    private PartySummary salesAgent;
    
    /**
    * @generated
    */
    private DeliveryReceiver orderReceiver;
    
    /**
    * @generated
    */
    private PartySummary orderInitiator;
    
    /**
    * @generated
    */
    private PartySummary vendor;
    
    

    /**
    * @generated
    */
    public OrderStatus getStatus() {
        return this.status;
    }
    
    /**
    * @generated
    */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    
    
    
    /**
    * @generated
    */
    public TimeDate getDateCreated() {
        return this.dateCreated;
    }

    /**
    * @generated
    */
    public void setDateCreated(TimeDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
    * @generated
    */
    public String getSalesChannel() {
        return this.salesChannel;
    }

    /**
    * @generated
    */
    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    /**
    * @generated
    */
    public String getTermsAndCondition() {
        return this.termsAndCondition;
    }

    /**
    * @generated
    */
    public void setTermsAndCondition(String termsAndCondition) {
        this.termsAndCondition = termsAndCondition;
    }

    /**
    * @generated
    */
    public RuleContext getDiscountContext() {
        return this.discountContext;
    }

    /**
    * @generated
    */
    public void setDiscountContext(RuleContext discountContext) {
        this.discountContext = discountContext;
    }

    /**
    * @generated
    */
    public PartySummary getSalesAgent() {
        return this.salesAgent;
    }
    
    /**
    * @generated
    */
    public void setSalesAgent(PartySummary salesAgent) {
        this.salesAgent = salesAgent;
    }
    
    
    /**
    * @generated
    */
    public Set<OrderLine> getLineItems() {
        if (this.lineItems == null) {
            this.lineItems = new HashSet<OrderLine>();
        }
        return this.lineItems;
    }
    
    /**
    * @generated
    */
    public void setLineItems(Set<OrderLine> lineItems) {
        this.lineItems = lineItems;
    }
    
    
    /**
    * @generated
    */
    public DeliveryReceiver getOrderReceiver() {
        return this.orderReceiver;
    }
    
    /**
    * @generated
    */
    public void setOrderReceiver(DeliveryReceiver orderReceiver) {
        this.orderReceiver = orderReceiver;
    }
    
    
    /**
    * @generated
    */
    public PartySummary getPaymentReceiver() {
        return this.paymentReceiver;
    }
    
    /**
    * @generated
    */
    public void setPaymentReceiver(PartySummary paymentReceiver) {
        this.paymentReceiver = paymentReceiver;
    }
    
    
    /**
    * @generated
    */
    public Set<ChargeLine> getChargeLines() {
        if (this.chargeLines == null) {
            this.chargeLines = new HashSet<ChargeLine>();
        }
        return this.chargeLines;
    }
    
    /**
    * @generated
    */
    public void setChargeLines(Set<ChargeLine> chargeLines) {
        this.chargeLines = chargeLines;
    }
    
    
    /**
    * @generated
    */
    public PartySummary getOrderInitiator() {
        return this.orderInitiator;
    }
    
    /**
    * @generated
    */
    public void setOrderInitiator(PartySummary orderInitiator) {
        this.orderInitiator = orderInitiator;
    }
    
    
    /**
    * @generated
    */
    public PartySummary getVendor() {
        return this.vendor;
    }
    
    /**
    * @generated
    */
    public void setVendor(PartySummary vendor) {
        this.vendor = vendor;
    }
    
    
    /**
    * @generated
    */
    public PartySummary getPurchaser() {
        return this.purchaser;
    }
    
    /**
    * @generated
    */
    public void setPurchaser(PartySummary purchaser) {
        this.purchaser = purchaser;
    }
    
    
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
    public Set<OrderEvent> getAuditTrail() {
        if (this.auditTrail == null) {
            this.auditTrail = new HashSet<OrderEvent>();
        }
        return this.auditTrail;
    }

    /**
    * @generated
    */
    public void setAuditTrail(Set<OrderEvent> auditTrail) {
        this.auditTrail = auditTrail;
    }

    /**
    * @generated
    */
    public boolean acceptEvent(OrderEvent orderEvent)
    {
        //TODO
        return false;
    }

    /**
    * @generated
    */
    public boolean processDiscountEvent()
    {
        //TODO
        return false;
    }

    /**
    * @generated
    */
    public boolean processLifeCycleEvent()
    {
        //TODO
        return false;
    }

    /**
    * @generated
    */
    public boolean processAmendEvent()
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
    
    
    
}
