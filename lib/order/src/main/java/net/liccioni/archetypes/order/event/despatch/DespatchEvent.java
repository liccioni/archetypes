package net.liccioni.archetypes.order.event.despatch;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.event.OrderEvent;

@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public abstract class DespatchEvent extends OrderEvent {

    private final String despatchIdentifier;
    private final TimeDate date;
    @Builder.Default
    private final Set<String> shippingInstructions = new HashSet<>();
    private final DespatchLine despatchLines;
}
