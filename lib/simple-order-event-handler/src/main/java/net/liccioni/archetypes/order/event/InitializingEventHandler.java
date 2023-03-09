package net.liccioni.archetypes.order.event;

import java.util.Optional;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderLine;
import net.liccioni.archetypes.order.OrderLineIdentifier;
import net.liccioni.archetypes.order.OrderStatus;
import net.liccioni.archetypes.order.event.amendment.AmendOrderLineEvent;
import net.liccioni.archetypes.order.event.amendment.AmendPartySummaryEvent;
import net.liccioni.archetypes.order.event.amendment.AmendTermsAndConditionsEvent;
import net.liccioni.archetypes.order.event.despatch.DespatchEvent;
import net.liccioni.archetypes.order.event.despatch.ReceiptEvent;
import net.liccioni.archetypes.order.event.discount.DiscountEvent;
import net.liccioni.archetypes.order.event.lifecycle.CancelEvent;
import net.liccioni.archetypes.order.event.lifecycle.CloseEvent;
import net.liccioni.archetypes.order.event.lifecycle.OpenEvent;
import net.liccioni.archetypes.order.event.payment.AcceptPaymentEvent;
import net.liccioni.archetypes.order.event.payment.AcceptRefundEvent;
import net.liccioni.archetypes.order.event.payment.InvoiceEvent;
import net.liccioni.archetypes.order.event.payment.MakePaymentEvent;
import net.liccioni.archetypes.order.event.payment.MakeRefundEvent;

public class InitializingEventHandler implements EventHandler {
    @Override
    public void handle(final AmendOrderLineEvent event, final Order order) {
        if (event.getNewOrderLine() != null) {
            extracted(order, event.getNewOrderLine().getOrderLineIdentifier()).ifPresent(orderLine -> {
                event.setOriginalOrderLine(orderLine);
                order.getLineItems().remove(orderLine);
            });
            order.getLineItems().add(event.getNewOrderLine());
        } else if (event.getOrderLineIdentifier() != null) {
            extracted(order, event.getOrderLineIdentifier()).ifPresent(orderLine -> {
                event.setOriginalOrderLine(orderLine);
                order.getLineItems().remove(orderLine);
            });
        }
    }

    private Optional<OrderLine> extracted(final Order order, final OrderLineIdentifier id) {
        return order.getLineItems().stream()
                .filter(p -> p.getOrderLineIdentifier().equals(id))
                .findFirst();
    }

    @Override
    public void handle(final AmendPartySummaryEvent event, final Order order) {
        event.getRole()
                .getAmendPartySummaryEventHandler()
                .handle(event, order);
    }

    @Override
    public void handle(final AmendTermsAndConditionsEvent event, final Order order) {
        event.setOldTermAndConditions(order.getTermsAndCondition());
        order.setTermsAndCondition(event.getNewTermAndConditions());
    }

    @Override
    public void handle(final DespatchEvent event, final Order order) {

    }

    @Override
    public void handle(final ReceiptEvent event, final Order order) {

    }

    @Override
    public void handle(final DiscountEvent event, final Order order) {

    }

    @Override
    public void handle(final CancelEvent event, final Order order) {
        order.setStatus(OrderStatus.CANCELLED);
    }

    @Override
    public void handle(final CloseEvent event, final Order order) {
        order.setStatus(OrderStatus.CLOSED);
    }

    @Override
    public void handle(final OpenEvent event, final Order order) {
        order.setStatus(OrderStatus.OPEN);
    }

    @Override
    public void handle(final AcceptPaymentEvent event, final Order order) {

    }

    @Override
    public void handle(final AcceptRefundEvent event, final Order order) {

    }

    @Override
    public void handle(final InvoiceEvent event, final Order order) {

    }

    @Override
    public void handle(final MakePaymentEvent event, final Order order) {

    }

    @Override
    public void handle(final MakeRefundEvent event, final Order order) {

    }
}
