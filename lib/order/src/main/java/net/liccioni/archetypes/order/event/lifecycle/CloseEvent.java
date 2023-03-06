package net.liccioni.archetypes.order.event.lifecycle;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.order.Order;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class CloseEvent extends LifeCycleEvent {

    @Override
    protected void internalProcess(final Order order) {
        order.close();
    }
}
