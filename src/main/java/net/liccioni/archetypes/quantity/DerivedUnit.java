package net.liccioni.archetypes.quantity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DerivedUnit implements Unit {

    private final String name;
    private final String symbol;
    private final String definition;
    private final SystemOfUnits systemOfUnits;
    private final Set<DerivedUnitTerm> terms = new HashSet<>();

    public DerivedUnit(final String name, final String symbol, final String definition,
                       final SystemOfUnits systemOfUnits) {
        this.name = name;
        this.symbol = symbol;
        this.definition = definition;
        this.systemOfUnits = systemOfUnits;
    }

    public Set<DerivedUnitTerm> getTerms() {
        return this.terms;
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

    public void addTerm(final DerivedUnitTerm term) {
        this.terms.add(term);
    }

    public void removeTerm(final DerivedUnitTerm term) {
        this.terms.remove(term);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DerivedUnit)) {
            return false;
        }
        DerivedUnit that = (DerivedUnit) o;
        return symbol.equals(that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return "DerivedUnit{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", systemOfUnits=" + systemOfUnits +
                '}';
    }
}
