package net.liccioni.archetypes.order.event.ammendment;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.order.Order;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class AmendPartySummaryEvent extends AmendEvent {


    @Override
    protected void internalProcess(final Order order) {

    }
}
