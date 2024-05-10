package net.liccioni.archetypes.quantity;

import java.math.BigDecimal;

public record StandardConversion(Unit source,
                                 Unit target,
                                 BigDecimal conversionFactor) {

    public StandardConversion(final Unit source, final Unit target, final Number conversionFactor) {
        this(source, target, BigDecimal.valueOf(conversionFactor.doubleValue()));
    }
}
