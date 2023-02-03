package net.liccioni.archetypes.quantity;

import java.util.Objects;

public class SimpleUnit implements Unit {

    private final String name;
    private final String symbol;
    private final String definition;
    private final SystemOfUnits systemOfUnits;

    public SimpleUnit(final String name,
                      final String symbol,
                      final String definition,
                      final SystemOfUnits systemOfUnits) {
        this.name = name;
        this.symbol = symbol;
        this.definition = definition;
        this.systemOfUnits = systemOfUnits;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public final String getDefinition() {
        return this.definition;
    }

    @Override
    public final SystemOfUnits getSystemOfUnits() {
        return this.systemOfUnits;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Unit)) {
            return false;
        }
        Unit that = (Unit) o;
        return that.isEqualTo(that);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(symbol, systemOfUnits);
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + getName() + '\'' +
                ", symbol='" + getSymbol() + '\'' +
                ", definition='" + getDefinition() + '\'' +
                ", systemOfUnits=" + getSystemOfUnits() +
                '}';
    }
}
