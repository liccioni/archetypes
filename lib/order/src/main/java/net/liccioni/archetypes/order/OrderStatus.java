package net.liccioni.archetypes.order;

import lombok.Setter;
import net.liccioni.archetypes.order.event.EventHandler;
import net.liccioni.archetypes.order.event.OrderEvent;
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

public enum OrderStatus implements EventHandler {
    CLOSED, CANCELLED, OPEN, INITIALIZING;

    @Setter
    private EventHandler delegate;

    public void handle(final Order order, final OrderEvent orderEvent) {
        orderEvent.process(this, order);
    }

    @Override
    public void handle(final AmendOrderLineEvent event, final Order order) {
        delegate.handle(event, order);
    }

    @Override
    public void handle(final AmendPartySummaryEvent event, final Order order) {
        delegate.handle(event, order);
    }

    @Override
    public void handle(final AmendTermsAndConditionsEvent event, final Order order) {
        delegate.handle(event, order);
    }

    @Override
    public void handle(final DespatchEvent event, final Order order) {
        delegate.handle(event, order);
    }

    @Override
    public void handle(final ReceiptEvent event, final Order order) {
        delegate.handle(event, order);
    }

    @Override
    public void handle(final DiscountEvent event, final Order order) {
        delegate.handle(event, order);
    }

    @Override
    public void handle(final CancelEvent event, final Order order) {
        delegate.handle(event, order);
    }

    @Override
    public void handle(final CloseEvent event, final Order order) {
        delegate.handle(event, order);
    }

    @Override
    public void handle(final OpenEvent event, final Order order) {
        delegate.handle(event, order);
    }

    @Override
    public void handle(final AcceptPaymentEvent event, final Order order) {
        delegate.handle(event, order);
    }

    @Override
    public void handle(final AcceptRefundEvent event, final Order order) {
        delegate.handle(event, order);
    }

    @Override
    public void handle(final InvoiceEvent event, final Order order) {
        delegate.handle(event, order);
    }

    @Override
    public void handle(final MakePaymentEvent event, final Order order) {
        delegate.handle(event, order);
    }

    @Override
    public void handle(final MakeRefundEvent event, final Order order) {
        delegate.handle(event, order);
    }
}
