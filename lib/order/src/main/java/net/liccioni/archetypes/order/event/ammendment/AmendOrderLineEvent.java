package net.liccioni.archetypes.order.event.ammendment;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderLine;
import net.liccioni.archetypes.order.OrderLineIdentifier;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class AmendOrderLineEvent extends AmendEvent {

    OrderLineIdentifier orderLineIdentifier;

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


    @Override
    protected void internalProcess(final Order order) {

    }
}
