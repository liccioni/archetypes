package net.liccioni.archetypes.quantity;

import java.math.BigDecimal;
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
                .filter(p -> p.getSource().equals(quantity.getMetric()))
                .map(p -> quantity.getAmount().multiply(p.getConversionFactor()))
                .map(p -> new Quantity(p, targetUnit))
                .findFirst().orElseThrow(() -> new IllegalStateException(
                        "Cannot find converter for " + quantity.getMetric() + " to " + targetUnit));
    }
}
