package net.liccioni.archetypes.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import net.liccioni.archetypes.order.event.OrderEvent;
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
}