package net.liccioni.archetypes.order.event;


import net.liccioni.archetypes.order.OrderLine;
import net.liccioni.archetypes.order.OrderLineIdentifier;

/**
 * @generated
 */
public class AmendOrderLineEvent extends AmendEvent {

    /**
     * @generated
     */
    private OrderLineIdentifier orderLineIdentifier;


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


    //                          Operations                                  


    /**
     * @generated
     */
    public OrderLine getNewOrderLine() {
        //TODO
        return null;
    }


    /**
     * @generated
     */
    public OrderLine getOriginalOrderLine() {
        //TODO
        return null;
    }


}
