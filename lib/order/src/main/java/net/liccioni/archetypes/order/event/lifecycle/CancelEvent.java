package net.liccioni.archetypes.order.event.lifecycle;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.order.Order;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class CancelEvent extends LifeCycleEvent {

    String reason;

    @Override
    protected void internalProcess(final Order order) {
        order.cancel();
    }
}
