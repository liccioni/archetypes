package net.liccioni.archetypes.quantity;

import java.math.BigDecimal;

public class StandardConversion {

    private final Unit source;
    private final Unit target;
    private final BigDecimal conversionFactor;

    public StandardConversion(final Unit source, final Unit target, final Number conversionFactor) {
        this.source = source;
        this.target = target;
        this.conversionFactor = BigDecimal.valueOf(conversionFactor.doubleValue());
    }

    public Unit getSource() {
        return source;
    }

    public Unit getTarget() {
        return target;
    }

    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }
}
