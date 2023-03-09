package net.liccioni.archetypes.order;

import lombok.Getter;
import lombok.Setter;
import net.liccioni.archetypes.order.event.amendment.AmendPartySummaryEventHandler;

public enum PartySummaryRoleInOrder {
    VENDOR,
    SALES_AGENT,
    PAYMENT_RECEIVER,
    ORDER_INITIATOR,
    PURCHASER,
    ORDER_RECEIVER,
    ORDER_LINE_RECEIVER;

    @Getter
    @Setter
    private AmendPartySummaryEventHandler amendPartySummaryEventHandler;
}
