package net.liccioni.archetypes.order.event.amendment;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.order.event.OrderEvent;

@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public abstract class AmendEvent extends OrderEvent {

    private final String reason;
}
