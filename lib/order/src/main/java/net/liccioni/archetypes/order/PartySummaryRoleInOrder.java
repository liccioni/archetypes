package net.liccioni.archetypes.order;

import java.util.function.BiConsumer;
import java.util.function.Function;
import net.liccioni.archetypes.order.event.amendment.AmendPartySummaryEvent;

public enum PartySummaryRoleInOrder {
    VENDOR((order, event) -> {
        event.setOldPartySummary(order.getVendor());
        order.setVendor(event.getNewPartySummary());
    }),
    SALES_AGENT((order, event) -> {
        event.setOldPartySummary(order.getSalesAgent());
        order.setSalesAgent(event.getNewPartySummary());
    }),
    PAYMENT_RECEIVER((order, event) -> {
        event.setOldPartySummary(order.getPaymentReceiver());
        order.setPaymentReceiver(event.getNewPartySummary());
    }),
    ORDER_INITIATOR((order, event) -> {
        event.setOldPartySummary(order.getOrderInitiator());
        order.setOrderInitiator(event.getNewPartySummary());
    }),
    PURCHASER((order, event) -> {
        event.setOldPartySummary(order.getPurchaser());
        order.setPurchaser(event.getNewPartySummary());
    }),
    ORDER_RECEIVER((order, event) -> {
        event.setOldPartySummary(order.getOrderReceiver());
        order.setOrderReceiver((DeliveryReceiver) event.getNewPartySummary());
    }),
    ORDER_LINE_RECEIVER((order, event) -> {
        order.getLineItems().stream().filter(p->p.getOrderLineIdentifier().equals(event.getOrderLineIdentifier()))
                .findFirst().ifPresent(o-> {
                    event.setOldPartySummary(o.getOrderLineReceiver());
                    o.setOrderLineReceiver((DeliveryReceiver) event.getNewPartySummary());
                });
    });

    private final BiConsumer<Order,AmendPartySummaryEvent> internalSetPartySummary;

    PartySummaryRoleInOrder(final BiConsumer<Order,AmendPartySummaryEvent> internalSetPartySummary) {
        this.internalSetPartySummary = internalSetPartySummary;
    }

    public void handle(final AmendPartySummaryEvent event, final Order order) {
        internalSetPartySummary.accept(order, event);
    }
}
