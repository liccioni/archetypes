package net.liccioni.archetypes.money;

import net.liccioni.archetypes.quantity.Metric;
import net.liccioni.archetypes.quantity.Quantity;

import java.math.BigDecimal;

public interface Money extends Quantity {

    Currency currency();

    @Override
    default Quantity multiply(final Quantity quantity) {
        throw new UnsupportedOperationException("Money cannot be multiplied by anything " + this + " * " + quantity);
    }

    @Override
    default Quantity divide(final Quantity quantity) {
        if (quantity instanceof Money) {
            throw new IllegalArgumentException("Money cannot be divided by money " + this + " / " + quantity);
        }
        return Quantity.divide(this, quantity);
    }

    @Override
    default Metric metric() {
        return currency();
    }
}
