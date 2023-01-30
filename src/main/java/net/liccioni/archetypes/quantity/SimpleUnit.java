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
    public String getName() {
        return this.name;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public String getDefinition() {
        return this.definition;
    }

    @Override
    public SystemOfUnits getSystemOfUnits() {
        return this.systemOfUnits;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SimpleUnit)) {
            return false;
        }
        SimpleUnit that = (SimpleUnit) o;
        return name.equals(that.name) && symbol.equals(that.symbol) && systemOfUnits == that.systemOfUnits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, symbol, systemOfUnits);
    }

    @Override
    public String toString() {
        return "SimpleUnit{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", definition='" + definition + '\'' +
                ", systemOfUnits=" + systemOfUnits +
                '}';
    }
}
