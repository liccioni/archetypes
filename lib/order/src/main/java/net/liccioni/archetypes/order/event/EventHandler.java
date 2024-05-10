package net.liccioni.archetypes.order.event;

import net.liccioni.archetypes.order.Order;
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

public interface EventHandler {

    default EventHandled handle(final AmendOrderLineEvent event, final Order order) {
        return new EventHandled(event, order);
    }

    default EventHandled handle(final AmendPartySummaryEvent event, final Order order) {
        return new EventHandled(event, order);
    }

    default EventHandled handle(final AmendTermsAndConditionsEvent event, final Order order) {
        return new EventHandled(event, order);
    }

    default EventHandled handle(final DespatchEvent event, final Order order) {
        return new EventHandled(event, order);
    }

    default EventHandled handle(final ReceiptEvent event, final Order order) {
        return new EventHandled(event, order);
    }

    default EventHandled handle(final DiscountEvent event, final Order order) {
        return new EventHandled(event, order);
    }

    default EventHandled handle(final CancelEvent event, final Order order) {
        return new EventHandled(event, order);
    }

    default EventHandled handle(final CloseEvent event, final Order order) {
        return new EventHandled(event, order);
    }

    default EventHandled handle(final OpenEvent event, final Order order) {
        return new EventHandled(event, order);
    }

    default EventHandled handle(final AcceptPaymentEvent event, final Order order) {
        return new EventHandled(event, order);
    }

    default EventHandled handle(final AcceptRefundEvent event, final Order order) {
        return new EventHandled(event, order);
    }

    default EventHandled handle(final InvoiceEvent event, final Order order) {
        return new EventHandled(event, order);
    }

    default EventHandled handle(final MakePaymentEvent event, final Order order) {
        return new EventHandled(event, order);
    }

    default EventHandled handle(final MakeRefundEvent event, final Order order) {
        return new EventHandled(event, order);
    }
}
