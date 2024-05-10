package net.liccioni.archetypes.order;

import lombok.Setter;
import net.liccioni.archetypes.order.event.EventHandled;
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
import net.liccioni.archetypes.order.event.payment.*;

public enum OrderStatus implements EventHandler {
    CLOSED, CANCELLED, OPEN, INITIALIZING;

    @Setter
    private EventHandler delegate;

    public EventHandled handle(final Order order, final OrderEvent orderEvent) {

        return orderEvent.process(this, order);
    }

    @Override
    public EventHandled handle(final AmendOrderLineEvent event, final Order order) {
        return delegate.handle(event, order);
    }

    @Override
    public EventHandled handle(final AmendPartySummaryEvent event, final Order order) {
        return delegate.handle(event, order);
    }

    @Override
    public EventHandled handle(final AmendTermsAndConditionsEvent event, final Order order) {
        return delegate.handle(event, order);
    }

    @Override
    public EventHandled handle(final DespatchEvent event, final Order order) {
        return delegate.handle(event, order);
    }

    @Override
    public EventHandled handle(final ReceiptEvent event, final Order order) {
        return delegate.handle(event, order);
    }

    @Override
    public EventHandled handle(final DiscountEvent event, final Order order) {
        return delegate.handle(event, order);
    }

    @Override
    public EventHandled handle(final CancelEvent event, final Order order) {
        return delegate.handle(event, order);
    }

    @Override
    public EventHandled handle(final CloseEvent event, final Order order) {
        return delegate.handle(event, order);
    }

    @Override
    public EventHandled handle(final OpenEvent event, final Order order) {
        return delegate.handle(event, order);
    }

    @Override
    public EventHandled handle(final AcceptPaymentEvent event, final Order order) {
        return delegate.handle(event, order);
    }

    @Override
    public EventHandled handle(final AcceptRefundEvent event, final Order order) {
        return delegate.handle(event, order);
    }

    @Override
    public EventHandled handle(final InvoiceEvent event, final Order order) {
        return delegate.handle(event, order);
    }

    @Override
    public EventHandled handle(final MakePaymentEvent event, final Order order) {
        return delegate.handle(event, order);
    }

    @Override
    public EventHandled handle(final MakeRefundEvent event, final Order order) {
        return delegate.handle(event, order);
    }
}
