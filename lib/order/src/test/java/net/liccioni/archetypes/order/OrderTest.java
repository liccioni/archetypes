package net.liccioni.archetypes.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import net.liccioni.archetypes.order.event.OrderEvent;
import net.liccioni.archetypes.order.event.amendment.AmendOrderLineEvent;
import net.liccioni.archetypes.order.event.amendment.AmendPartySummaryEvent;
import net.liccioni.archetypes.order.event.amendment.AmendTermsAndConditionsEvent;
import net.liccioni.archetypes.order.event.lifecycle.CancelEvent;
import net.liccioni.archetypes.order.event.lifecycle.CloseEvent;
import net.liccioni.archetypes.order.event.lifecycle.OpenEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OrderTest {

    public static Stream<Arguments> shouldAcceptLifeCycleEventArgs() {
        return Stream.of(
                Arguments.of(OpenEvent.builder().build(), OrderStatus.OPEN),
                Arguments.of(CloseEvent.builder().build(), OrderStatus.CLOSED),
                Arguments.of(CancelEvent.builder().build(), OrderStatus.CANCELLED)
        );
    }

    @ParameterizedTest
    @MethodSource("shouldAcceptLifeCycleEventArgs")
    void shouldAcceptLifeCycleEvent(final OrderEvent event, final OrderStatus expected) {
        var order = PurchaseOrder.builder().orderIdentifier(OrderIdentifier.builder().id("o1").build()).build();
        order.acceptEvent(event);
        assertThat(order.getAuditTrail()).containsExactly(event);
        assertThat(order.getStatus()).isEqualTo(expected);
        assertThat(event.getOrderIdentifier()).isEqualTo(order.getOrderIdentifier());
    }

    @Test
    void shouldNotCancelClosedOrder() {
        var order = PurchaseOrder.builder().orderIdentifier(OrderIdentifier.builder().id("o1").build()).build();
        order.acceptEvent(CloseEvent.builder().build());
        var thrown = assertThrows(IllegalStateException.class, () -> {
            order.acceptEvent(CancelEvent.builder().build());
        });
        assertThat(thrown.getMessage()).isEqualTo(
                String.format("cannot cancel closed order %s", order));
    }

    @Test
    void shouldNotCloseCancelledOrder() {
        var order = PurchaseOrder.builder().orderIdentifier(OrderIdentifier.builder().id("o1").build()).build();
        order.acceptEvent(CancelEvent.builder().build());
        var thrown = assertThrows(IllegalStateException.class, () -> {
            order.acceptEvent(CloseEvent.builder().build());
        });
        assertThat(thrown.getMessage()).isEqualTo(
                String.format("cannot close cancelled order %s", order));
    }

    @Test
    void shouldAmendTermsAndConditions() {
        final var oldTermsAndConditions = "original terms and conditions";
        final var newTermsAndConditions = "new terms and conditions";
        var order = PurchaseOrder.builder().orderIdentifier(OrderIdentifier.builder().id("o1").build())
                .termsAndCondition(oldTermsAndConditions)
                .build();
        final var event = AmendTermsAndConditionsEvent.builder()
                .newTermAndConditions(newTermsAndConditions)
                .build();
        order.acceptEvent(event);
        assertThat(order.getAuditTrail()).containsExactly(event);
        assertThat(order.getTermsAndCondition()).isEqualTo(newTermsAndConditions);
        assertThat(event.getOldTermAndConditions()).isEqualTo(oldTermsAndConditions);
    }

    @Test
    void shouldAmendPartySummary() {

        final PartySummary oldSalesAgent = PartySummary.builder().emailAddress("sales@agent.com").build();
        final PartySummary newSalesAgent = PartySummary.builder().emailAddress("new_sales@agent.com").build();
        var order = PurchaseOrder.builder().orderIdentifier(OrderIdentifier.builder().id("o1").build())
                .salesAgent(oldSalesAgent)
                .build();
        final var event = AmendPartySummaryEvent.builder()
                .newPartySummary(newSalesAgent)
                .role(PartySummaryRoleInOrder.SALES_AGENT)
                .build();
        order.acceptEvent(event);
        assertThat(order.getAuditTrail()).containsExactly(event);
        assertThat(order.getSalesAgent()).isEqualTo(newSalesAgent);
        assertThat(event.getOldPartySummary()).isEqualTo(oldSalesAgent);
    }

    @Test
    void shouldAmendOrderLineReceiver() {
        final var oldReceiver = DeliveryReceiver.builder().emailAddress("sales@agent.com").build();
        final var newReceiver = DeliveryReceiver.builder().emailAddress("new_sales@agent.com").build();
        var order = PurchaseOrder.builder().orderIdentifier(OrderIdentifier.builder().id("o1").build()).build();
        final var ol1 = OrderLine.builder()
                .orderLineIdentifier(OrderLineIdentifier.builder().id("ol1").build())
                .orderLineReceiver(oldReceiver)
                .build();
        order.getLineItems().add(ol1);
        final var event = AmendPartySummaryEvent.builder()
                .orderLineIdentifier(ol1.getOrderLineIdentifier())
                .newPartySummary(newReceiver)
                .role(PartySummaryRoleInOrder.ORDER_LINE_RECEIVER)
                .build();
        order.acceptEvent(event);
        assertThat(order.getAuditTrail()).containsExactly(event);
        assertThat(ol1.getOrderLineReceiver()).isEqualTo(newReceiver);
        assertThat(event.getOldPartySummary()).isEqualTo(oldReceiver);
    }

    @Test
    void shouldAmendOrderLine() {
        var order = PurchaseOrder.builder().orderIdentifier(OrderIdentifier.builder().id("o1").build()).build();
        final var ol1 = OrderLine.builder()
                .orderLineIdentifier(OrderLineIdentifier.builder().id("ol1").build())
                .build();
        final var ol2 = OrderLine.builder()
                .orderLineIdentifier(OrderLineIdentifier.builder().id("ol2").build())
                .build();
        final var ol3 = OrderLine.builder()
                .orderLineIdentifier(OrderLineIdentifier.builder().id("ol3").build())
                .build();
        final var ol2Modified = ol2.toBuilder().comment("changed").build();
        order.getLineItems().add(ol1);
        order.getLineItems().add(ol2);

        final var addOlEvent = AmendOrderLineEvent.builder().newOrderLine(ol3).build();
        order.acceptEvent(addOlEvent);
        assertThat(order.getLineItems()).containsExactlyInAnyOrder(ol1,ol2,ol3);

        final var modifyOlEvent = AmendOrderLineEvent.builder().newOrderLine(ol2Modified).build();
        order.acceptEvent(modifyOlEvent);
        assertThat(order.getLineItems()).containsExactlyInAnyOrder(ol1,ol2Modified,ol3);

        final var deleteOlEvent = AmendOrderLineEvent.builder()
                .orderLineIdentifier(ol1.getOrderLineIdentifier()).build();
        order.acceptEvent(deleteOlEvent);
        assertThat(order.getLineItems()).containsExactlyInAnyOrder(ol2Modified,ol3);
    }
}