package net.liccioni.archetypes.order.event.despatch;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.event.OrderEvent;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class ReceiptEvent extends OrderEvent {

    String deliveryIdentifier;
    TimeDate date;
    ReceiptLine receiptLines;

    @Override
    protected void internalProcess(final Order order) {

    }
}
