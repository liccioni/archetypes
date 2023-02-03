package net.liccioni.archetypes.quantity;

import java.util.Objects;

public interface Unit extends Metric {

    SystemOfUnits getSystemOfUnits();

    default boolean isEqualTo(Unit other) {
        return Objects.equals(getSymbol(), other.getSymbol()) && Objects.equals(getSystemOfUnits(), getSystemOfUnits());
    }

    @Override
    default boolean isEqualTo(Metric metric) {
        if (metric instanceof Unit) {
            return isEqualTo((Unit) metric);
        }
        return false;
    }
}
