package net.liccioni.archetypes.quantity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record DerivedUnit(String name,
                          String symbol,
                          String definition,
                          SystemOfUnits systemOfUnits,
                          Map<Metric, DerivedUnitTerm> terms) implements SimpleUnit {

    public DerivedUnit(String name,
                       String symbol,
                       String definition,
                       SystemOfUnits systemOfUnits,
                       Map<Metric, DerivedUnitTerm> terms) {
        this.name = name;
        this.terms = Optional.ofNullable(terms).orElseGet(ConcurrentHashMap::new);
        this.symbol = Optional.ofNullable(symbol).orElseGet(this::generateSymbol);
        this.definition = definition;
        this.systemOfUnits = systemOfUnits;
    }

    public DerivedUnit(final SystemOfUnits systemOfUnits, DerivedUnitTerm... terms) {
        this("", null, "", systemOfUnits, processTerms(terms));
    }

    public DerivedUnit(final Metric metric, DerivedUnitTerm... terms) {
        this("", null, "", processMetric(metric), processTerms(terms));
    }

    private static SystemOfUnits processMetric(Metric metric) {
        return metric instanceof Unit ? ((Unit) metric).systemOfUnits() : null;
    }

    private static Map<Metric, DerivedUnitTerm> processTerms(DerivedUnitTerm[] terms) {
        return Arrays.stream(terms)
                .flatMap(DerivedUnit::getDerivedUnitTerm)
                .collect(Collectors.toMap(DerivedUnitTerm::unit, Function.identity(), DerivedUnit::mergeUnits,
                        (Supplier<Map<Metric, DerivedUnitTerm>>) ConcurrentHashMap::new));
    }

    private static DerivedUnitTerm mergeUnits(DerivedUnitTerm unit1, DerivedUnitTerm unit2) {
        return Optional.of(unit1)
                .map(DerivedUnitTerm::power)
                .map(p -> p + unit2.power())
                .filter(p -> p != 0)
                .map(p -> new DerivedUnitTerm(p, unit1.unit()))
                .orElse(null);
    }

    private static Stream<DerivedUnitTerm> getDerivedUnitTerm(DerivedUnitTerm term) {
        if (term.unit() instanceof DerivedUnit) {
            return ((DerivedUnit) term.unit()).terms.values().stream();
        } else {
            return Stream.of(term);
        }
    }

    private String generateSymbol() {
        return this.terms.values().stream()
                .sorted(Comparator.comparing(o -> o.unit().symbol()))
                .map(p -> p.unit().symbol() + (p.power() != 1 ? p.power() : ""))
                .collect(Collectors.joining(","));
    }
}
