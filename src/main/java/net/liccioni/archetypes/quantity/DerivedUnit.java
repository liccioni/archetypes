package net.liccioni.archetypes.quantity;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DerivedUnit implements Unit {

    private final SystemOfUnits systemOfUnits;
    private final Map<Metric, DerivedUnitTerm> terms = new ConcurrentHashMap<>();

    public DerivedUnit(final SystemOfUnits systemOfUnits) {
        this.systemOfUnits = systemOfUnits;
    }

    @Override
    public String getName() {
        return this.terms.values().stream().map(p -> p.getUnit().getSymbol() + p.getPower())
                .collect(Collectors.joining(","));
    }

    @Override
    public String getSymbol() {
        return this.terms.values().stream().map(p -> p.getUnit().getSymbol() + p.getPower())
                .collect(Collectors.joining(","));
    }

    @Override
    public String getDefinition() {
        return "";
    }

    @Override
    public SystemOfUnits getSystemOfUnits() {
        return this.systemOfUnits;
    }

    public void addTerm(final DerivedUnitTerm term) {
        if (term.getUnit() instanceof DerivedUnit) {
            ((DerivedUnit) term.getUnit()).terms.values().forEach(this::addTermInternal);
        } else {
            addTermInternal(term);
        }
    }

    private void addTermInternal(final DerivedUnitTerm term) {
        this.terms.computeIfPresent(term.getUnit(),
                (metric, existingTerm) -> new DerivedUnitTerm(term.getPower() + existingTerm.getPower(), metric));
        this.terms.putIfAbsent(term.getUnit(), term);
    }

    public void removeTerm(final DerivedUnitTerm term) {
        this.terms.remove(term.getUnit());
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
        return getSymbol().equals(that.getSymbol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSymbol());
    }

    @Override
    public String toString() {
        return "DerivedUnit{" +
                "name='" + getName() + '\'' +
                ", symbol='" + getSymbol() + '\'' +
                ", systemOfUnits=" + systemOfUnits +
                ", terms=" + terms.values().stream().map(Object::toString).collect(Collectors.joining(",")) +
                '}';
    }
}
