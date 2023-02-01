package net.liccioni.archetypes.quantity;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
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
        return this.getSymbol();
    }

    @Override
    public String getSymbol() {
        return this.terms.values().stream()
                .sorted(Comparator.comparing(o -> o.getUnit().getSymbol()))
                .map(p -> p.getUnit().getSymbol() + (p.getPower() != 1 ? p.getPower() : ""))
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

        this.terms.compute(term.getUnit(), (metric, derivedUnitTerm) -> {

            if (derivedUnitTerm == null) {
                return term;
            }

            return Optional.of(derivedUnitTerm)
                    .map(DerivedUnitTerm::getPower)
                    .map(p -> p + term.getPower())
                    .filter(p -> p != 0)
                    .map(p -> new DerivedUnitTerm(p, metric))
                    .orElse(null);
        });
    }

    public void removeTerm(final DerivedUnitTerm term) {
        this.terms.remove(term.getUnit());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Unit)) {
            return false;
        }
        Unit that = (Unit) o;
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
