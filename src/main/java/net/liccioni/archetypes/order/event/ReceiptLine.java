package net.liccioni.archetypes.order.event;


import net.liccioni.archetypes.order.OrderLineIdentifier;

/**
 * @generated
 */
public class ReceiptLine {

    /**
     * @generated
     */
    private OrderLineIdentifier orderLineIdentifier;

    /**
     * @generated
     */
    private int numberReceived;

    /**
     * @generated
     */
    private boolean isAssessed;


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
    public int getNumberReceived() {
        return this.numberReceived;
    }

    /**
     * @generated
     */
    public void setNumberReceived(int numberReceived) {
        this.numberReceived = numberReceived;
    }


    /**
     * @generated
     */
    public boolean getIsAssessed() {
        return this.isAssessed;
    }

    /**
     * @generated
     */
    public void setIsAssessed(boolean isAssessed) {
        this.isAssessed = isAssessed;
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
