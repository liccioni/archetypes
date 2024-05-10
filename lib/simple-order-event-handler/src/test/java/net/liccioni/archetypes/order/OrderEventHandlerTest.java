package net.liccioni.archetypes.order;

import net.liccioni.archetypes.order.event.*;
import net.liccioni.archetypes.order.event.amendment.AmendOrderLineEvent;
import net.liccioni.archetypes.order.event.amendment.AmendPartySummaryEvent;
import net.liccioni.archetypes.order.event.amendment.AmendTermsAndConditionsEvent;
import net.liccioni.archetypes.order.event.lifecycle.CancelEvent;
import net.liccioni.archetypes.order.event.lifecycle.CloseEvent;
import net.liccioni.archetypes.order.event.lifecycle.OpenEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderEventHandlerTest {

    @BeforeEach
    void setUp() {
        OrderStatus.CLOSED.setDelegate(new ClosedEventHandler());
        OrderStatus.CANCELLED.setDelegate(new CancelledEventHandler());
        OrderStatus.OPEN.setDelegate(new OpenEventHandler());
        OrderStatus.INITIALIZING.setDelegate(new InitializingEventHandler());

        PartySummaryRoleInOrder.VENDOR.setAmendPartySummaryEventHandler((event, order) -> {
//            event.setOldPartySummary(order.vendor());
//            order.setVendor(event.newPartySummary());
            return null;
        });

        PartySummaryRoleInOrder.SALES_AGENT.setAmendPartySummaryEventHandler((event, order) -> {
            return new EventHandled(
                    event.toBuilder().oldPartySummary(order.salesAgent()).build(),
                    order.setSalesAgent(event.newPartySummary()));
        });

        PartySummaryRoleInOrder.PAYMENT_RECEIVER.setAmendPartySummaryEventHandler((event, order) -> {
//            event.setOldPartySummary(order.getPaymentReceiver());
//            order.setPaymentReceiver(event.getNewPartySummary());
            return null;
        });

        PartySummaryRoleInOrder.ORDER_INITIATOR.setAmendPartySummaryEventHandler((event, order) -> {
//            event.setOldPartySummary(order.getOrderInitiator());
//            order.setOrderInitiator(event.getNewPartySummary());
            return null;
        });

        PartySummaryRoleInOrder.PURCHASER.setAmendPartySummaryEventHandler((event, order) -> {
//            event.setOldPartySummary(order.getPurchaser());
//            order.setPurchaser(event.getNewPartySummary());
            return null;
        });

        PartySummaryRoleInOrder.ORDER_RECEIVER.setAmendPartySummaryEventHandler((event, order) -> {
//            event.setOldPartySummary(order.getOrderReceiver());
//            order.setOrderReceiver((DeliveryReceiver) event.getNewPartySummary());
            return null;
        });

        PartySummaryRoleInOrder.ORDER_LINE_RECEIVER.setAmendPartySummaryEventHandler((event, order) -> {
            return order.lineItems().stream()
                    .filter(p -> p.orderLineIdentifier().equals(event.orderLineIdentifier()))
                    .findFirst().map(o -> {
//                        event.setOldPartySummary(o.orderLineReceiver());
//                        o.setOrderLineReceiver((DeliveryReceiver) event.newPartySummary());
                        order.lineItems().remove(o);
                        order.lineItems().add(o.toBuilder().orderLineReceiver((DeliveryReceiver) event.newPartySummary()).build());
                        return new EventHandled(event.toBuilder()
                                .oldPartySummary(o.orderLineReceiver())
                                .build(), order);
                    }).orElseGet(() -> new EventHandled(event, order));
        });
    }

    public static Stream<Arguments> shouldAcceptLifeCycleEventArgs() {
        return Stream.of(Arguments.of(OpenEvent.builder().build(), OrderStatus.OPEN), Arguments.of(CloseEvent.builder().build(), OrderStatus.CLOSED), Arguments.of(CancelEvent.builder().build(), OrderStatus.CANCELLED));
    }

    @ParameterizedTest
    @MethodSource("shouldAcceptLifeCycleEventArgs")
    void shouldAcceptLifeCycleEvent(final OrderEvent event, final OrderStatus expected) {
        var order = PurchaseOrder.builder().orderIdentifier(OrderIdentifier.builder().id("o1").build()).build();
        final var newOrder = order.acceptEvent(event);
        assertThat(newOrder.auditTrail()).containsExactly(event);
        assertThat(newOrder.status()).isEqualTo(expected);
//        assertThat(event.orderIdentifier()).isEqualTo(order.orderIdentifier());
    }

    @Test
    void shouldNotCancelClosedOrder() {
        var order = PurchaseOrder.builder().orderIdentifier(OrderIdentifier.builder().id("o1").build()).build();
        Order closedOrder = order.acceptEvent(CloseEvent.builder().build());
        var thrown = assertThrows(IllegalStateException.class, () -> {
            closedOrder.acceptEvent(CancelEvent.builder().build());
        });
        assertThat(thrown.getMessage()).isEqualTo(String.format("cannot cancel closed order %s", closedOrder));
    }

    @Test
    void shouldNotCloseCancelledOrder() {
        var order = PurchaseOrder.builder().orderIdentifier(OrderIdentifier.builder().id("o1").build()).build();
        var cancelledOrder = order.acceptEvent(CancelEvent.builder().build());
        var thrown = assertThrows(IllegalStateException.class, () -> {
            cancelledOrder.acceptEvent(CloseEvent.builder().build());
        });
        assertThat(thrown.getMessage()).isEqualTo(String.format("cannot close cancelled order %s", cancelledOrder));
    }

    @Test
    void shouldAmendTermsAndConditions() {
        final var oldTermsAndConditions = "original terms and conditions";
        final var newTermsAndConditions = "new terms and conditions";
        var order = PurchaseOrder.builder().orderIdentifier(OrderIdentifier.builder().id("o1").build()).termsAndCondition(oldTermsAndConditions).build();
        final var event = AmendTermsAndConditionsEvent.builder().orderIdentifier(order.orderIdentifier()).newTermAndConditions(newTermsAndConditions).build();
        final var ammenedOrder = order.acceptEvent(event);
        assertThat(ammenedOrder.auditTrail()).containsExactly(event.toBuilder().oldTermAndConditions(oldTermsAndConditions).build());
        assertThat(ammenedOrder.termsAndCondition()).isEqualTo(newTermsAndConditions);
    }

    @Test
    void shouldAmendPartySummary() {

        final PartySummary oldSalesAgent = DeliveryReceiver.builder().emailAddress("sales@agent.com").build();
        final PartySummary newSalesAgent = DeliveryReceiver.builder().emailAddress("new_sales@agent.com").build();
        var order = PurchaseOrder.builder().orderIdentifier(OrderIdentifier.builder().id("o1").build()).salesAgent(oldSalesAgent).build();
        final var event = AmendPartySummaryEvent.builder().newPartySummary(newSalesAgent).role(PartySummaryRoleInOrder.SALES_AGENT).build();
        final var ammendedOrder = order.acceptEvent(event);
        assertThat(ammendedOrder.auditTrail()).containsExactly(event.toBuilder().oldPartySummary(oldSalesAgent).build());
        assertThat(ammendedOrder.salesAgent()).isEqualTo(newSalesAgent);
//        assertThat(event.oldPartySummary()).isEqualTo(oldSalesAgent);
    }

    @Test
    void shouldAmendOrderLineReceiver() {
        final var oldReceiver = DeliveryReceiver.builder().emailAddress("sales@agent.com").build();
        final var newReceiver = DeliveryReceiver.builder().emailAddress("new_sales@agent.com").build();
        var order = PurchaseOrder.builder().orderIdentifier(OrderIdentifier.builder().id("o1").build()).build();
        final var ol1 = OrderLine.builder().orderLineIdentifier(OrderLineIdentifier.builder().id("ol1").build()).orderLineReceiver(oldReceiver).build();
        order.lineItems().add(ol1);
        final var event = AmendPartySummaryEvent.builder().orderIdentifier(order.orderIdentifier()).orderLineIdentifier(ol1.orderLineIdentifier()).newPartySummary(newReceiver).role(PartySummaryRoleInOrder.ORDER_LINE_RECEIVER).build();
        var ammendedOrder = order.acceptEvent(event);
        assertThat(ammendedOrder.auditTrail()).containsExactly(event.toBuilder().oldPartySummary(oldReceiver).build());
        assertThat(ammendedOrder.lineItems()).containsExactly(ol1.toBuilder().orderLineReceiver(newReceiver).build());
    }

    @Test
    void shouldAmendOrderLine() {
        var order = PurchaseOrder.builder().orderIdentifier(OrderIdentifier.builder().id("o1").build()).build();
        final var ol1 = OrderLine.builder().orderLineIdentifier(OrderLineIdentifier.builder().id("ol1").build()).build();
        final var ol2 = OrderLine.builder().orderLineIdentifier(OrderLineIdentifier.builder().id("ol2").build()).build();
        final var ol3 = OrderLine.builder().orderLineIdentifier(OrderLineIdentifier.builder().id("ol3").build()).build();
        final var ol2Modified = ol2.toBuilder().comment("changed").build();
        order.lineItems().add(ol1);
        order.lineItems().add(ol2);

        final var addOlEvent = AmendOrderLineEvent.builder().orderIdentifier(order.orderIdentifier()).newOrderLine(ol3).build();
        order.acceptEvent(addOlEvent);
        assertThat(order.lineItems()).containsExactlyInAnyOrder(ol1, ol2, ol3);

        final var modifyOlEvent = AmendOrderLineEvent.builder().orderIdentifier(order.orderIdentifier()).newOrderLine(ol2Modified).build();
        order.acceptEvent(modifyOlEvent);
        assertThat(order.lineItems()).containsExactlyInAnyOrder(ol1, ol2Modified, ol3);

        final var deleteOlEvent = AmendOrderLineEvent.builder().orderIdentifier(order.orderIdentifier()).orderLineIdentifier(ol1.orderLineIdentifier()).build();
        order.acceptEvent(deleteOlEvent);
        assertThat(order.lineItems()).containsExactlyInAnyOrder(ol2Modified, ol3);
    }
}