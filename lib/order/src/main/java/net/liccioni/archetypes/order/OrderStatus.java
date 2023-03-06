package net.liccioni.archetypes.order;

import static java.lang.String.format;

import java.util.function.Consumer;

public enum OrderStatus {
    CLOSED(order -> {
        throw new IllegalStateException(format("cannot open closed order %s", order));
    }, order -> {
        throw new IllegalStateException(format("cannot cancel closed order %s", order));
    }, order -> {
        throw new IllegalStateException(format("cannot close closed order %s", order));
    }),
    CANCELLED(order -> {
        throw new IllegalStateException(format("cannot open cancelled order %s", order));
    }, order -> {
        throw new IllegalStateException(format("cannot cancel cancelled order %s", order));
    }, order -> {
        throw new IllegalStateException(format("cannot close cancelled order %s", order));
    }),
    OPEN(order -> {
        throw new IllegalStateException(format("cannot reopen opened order %s", order));
    }, order -> {
        order.setStatus(CANCELLED);
    }, order -> {
        order.setStatus(CLOSED);
    }),
    INITIALIZING(order -> {
        order.setStatus(OPEN);
    }, order -> {
        order.setStatus(CANCELLED);
    }, order -> {
        order.setStatus(CLOSED);
    });

    private final Consumer<Order> open;
    private final Consumer<Order> cancel;
    private final Consumer<Order> close;

    OrderStatus(final Consumer<Order> open,
                final Consumer<Order> cancel,
                final Consumer<Order> close) {
        this.open = open;
        this.cancel = cancel;
        this.close = close;
    }

    public void open(final Order order) {
        this.open.accept(order);
    }

    public void cancel(final Order order) {
        this.cancel.accept(order);
    }

    public void close(final Order order) {
        this.close.accept(order);
    }
}
