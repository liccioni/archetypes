package net.liccioni.archetypes.quantity;

public interface Unit extends Metric {

    SystemOfUnits getSystemOfUnits();

    default boolean isEqualTo(Unit other) {
        return getSymbol().equals(other.getSymbol()) && getSystemOfUnits().equals(other.getSystemOfUnits());
    }
}
