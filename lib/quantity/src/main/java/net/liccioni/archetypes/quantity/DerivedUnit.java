package net.liccioni.archetypes.quantity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class DerivedUnit extends SimpleUnit {

    @Getter(AccessLevel.NONE)
    Map<Metric, DerivedUnitTerm> terms = new ConcurrentHashMap<>();

    @Getter(lazy = true)
    String symbol = generateSymbol();

    public DerivedUnit(final SystemOfUnits systemOfUnits, DerivedUnitTerm... terms) {
        super("", "", "", systemOfUnits);
        Arrays.stream(terms).forEach(this::addTerm);
    }

    public DerivedUnit(final Metric metric, DerivedUnitTerm... terms) {
        super("", "", "", metric instanceof Unit ? ((Unit) metric).getSystemOfUnits() : null);
        Arrays.stream(terms).forEach(this::addTerm);
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

    private String generateSymbol() {
        return this.terms.values().stream()
                .sorted(Comparator.comparing(o -> o.getUnit().getSymbol()))
                .map(p -> p.getUnit().getSymbol() + (p.getPower() != 1 ? p.getPower() : ""))
                .collect(Collectors.joining(","));
    }
}
