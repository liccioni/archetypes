package net.liccioni.archetypes.quantity;

import java.math.BigDecimal;
import lombok.Value;

@Value
public class StandardConversion {

    Unit source;
    Unit target;
    BigDecimal conversionFactor;

    public StandardConversion(final Unit source, final Unit target, final Number conversionFactor) {
        this.source = source;
        this.target = target;
        this.conversionFactor = BigDecimal.valueOf(conversionFactor.doubleValue());
    }
}
