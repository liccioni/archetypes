package net.liccioni.archetypes.quantity;

import java.util.HashSet;
import java.util.Set;

public class UnitConverter {

    private final Set<StandardConversion> converters = new HashSet<>();

    public void addConverter(final StandardConversion converter) {
        this.converters.add(converter);
    }

    public void removeConverter(final StandardConversion converter) {
        this.converters.remove(converter);
    }

    public Quantity convert(Quantity quantity, Unit targetUnit) {

        return this.converters.stream()
                .filter(converter -> converterMatches(quantity.metric(), targetUnit, converter))
                .map(converter -> quantity.amount().multiply(converter.conversionFactor()))
                .map(convertedAmount -> new QuantityRecord(convertedAmount, targetUnit))
                .findFirst().orElseThrow(() -> new IllegalStateException(
                        "Cannot find converter for " + quantity.metric() + " to " + targetUnit));
    }

    private boolean converterMatches(final Metric sourceUnit, final Unit targetUnit,
                                     final StandardConversion converter) {
        return converter.source().isEqualTo(sourceUnit) &&
                converter.target().isEqualTo(targetUnit);
    }
}
