package net.liccioni.archetypes.order;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class DeliveryReceiver extends PartySummary {

    String deliveryInstructions;
}
