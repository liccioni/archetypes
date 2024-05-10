package net.liccioni.archetypes.quantity;

import java.util.Objects;

public interface Unit extends Metric {

    SystemOfUnits systemOfUnits();

    default boolean isEqualTo(Unit other) {
        return Objects.equals(symbol(), other.symbol()) && Objects.equals(systemOfUnits(), other.systemOfUnits());
    }

    @Override
    default boolean isEqualTo(Metric metric) {
        if (metric instanceof Unit) {
            return isEqualTo((Unit) metric);
        }
        return false;
    }
}
