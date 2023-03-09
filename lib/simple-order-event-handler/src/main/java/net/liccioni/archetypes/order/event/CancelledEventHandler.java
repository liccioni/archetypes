package net.liccioni.archetypes.order.event;

import static java.lang.String.format;

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
import net.liccioni.archetypes.order.event.payment.AcceptPaymentEvent;
import net.liccioni.archetypes.order.event.payment.AcceptRefundEvent;
import net.liccioni.archetypes.order.event.payment.InvoiceEvent;
import net.liccioni.archetypes.order.event.payment.MakePaymentEvent;
import net.liccioni.archetypes.order.event.payment.MakeRefundEvent;

public class CancelledEventHandler implements EventHandler {
    @Override
    public void handle(final AmendOrderLineEvent event, final Order order) {

    }

    @Override
    public void handle(final AmendPartySummaryEvent event, final Order order) {

    }

    @Override
    public void handle(final AmendTermsAndConditionsEvent event, final Order order) {

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
        throw new IllegalStateException(format("cannot cancel cancelled order %s", order));
    }

    @Override
    public void handle(final CloseEvent event, final Order order) {
        throw new IllegalStateException(format("cannot close cancelled order %s", order));
    }

    @Override
    public void handle(final OpenEvent event, final Order order) {
        throw new IllegalStateException(format("cannot open cancelled order %s", order));
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
