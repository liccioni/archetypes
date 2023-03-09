package net.liccioni.archetypes.order.event.despatch;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderStatus;
import net.liccioni.archetypes.order.event.OrderEvent;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class DespatchEvent extends OrderEvent {

    @NonNull
    String despatchIdentifier;
    @NonNull
    TimeDate date;
    @Builder.Default
    Set<String> shippingInstructions = new HashSet<>();
    @Builder.Default
    Set<DespatchLine> despatchLines = new HashSet<>();

    @Override
    public void process(final OrderStatus orderStatus, final Order order) {
        orderStatus.handle(this, order);
    }
}
