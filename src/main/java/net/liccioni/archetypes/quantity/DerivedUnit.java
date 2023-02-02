package net.liccioni.archetypes.quantity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DerivedUnit extends SimpleUnit {

    private final String symbol;
    private final Map<Metric, DerivedUnitTerm> terms = new ConcurrentHashMap<>();

    public DerivedUnit(final SystemOfUnits systemOfUnits, DerivedUnitTerm... terms) {
        super("", "", "", systemOfUnits);
        Arrays.stream(terms).forEach(this::addTerm);
        this.symbol = this.terms.values().stream()
                .sorted(Comparator.comparing(o -> o.getUnit().getSymbol()))
                .map(p -> p.getUnit().getSymbol() + (p.getPower() != 1 ? p.getPower() : ""))
                .collect(Collectors.joining(","));
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    private void addTerm(final DerivedUnitTerm term) {
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
}
