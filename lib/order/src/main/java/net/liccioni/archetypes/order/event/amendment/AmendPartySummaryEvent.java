package net.liccioni.archetypes.order.event.amendment;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderLineIdentifier;
import net.liccioni.archetypes.order.PartySummary;
import net.liccioni.archetypes.order.PartySummaryRoleInOrder;

@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class AmendPartySummaryEvent extends AmendEvent {

    @NonNull
    private final PartySummaryRoleInOrder role;
    private final OrderLineIdentifier orderLineIdentifier;
    private final PartySummary newPartySummary;
    private PartySummary oldPartySummary;

    @Override
    protected void internalProcess(final Order order) {
        role.handle(this, order);
    }
}
