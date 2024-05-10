package net.liccioni.archetypes.order;

import lombok.Setter;
import net.liccioni.archetypes.order.event.EventHandled;
import net.liccioni.archetypes.order.event.amendment.AmendPartySummaryEvent;
import net.liccioni.archetypes.order.event.amendment.AmendPartySummaryEventHandler;

public enum PartySummaryRoleInOrder {
    VENDOR,
    SALES_AGENT,
    PAYMENT_RECEIVER,
    ORDER_INITIATOR,
    PURCHASER,
    ORDER_RECEIVER,
    ORDER_LINE_RECEIVER;

    @Setter
    private AmendPartySummaryEventHandler amendPartySummaryEventHandler;

    public EventHandled handle(AmendPartySummaryEvent event, Order order) {
        return amendPartySummaryEventHandler.handle(event, order);
    }
}
