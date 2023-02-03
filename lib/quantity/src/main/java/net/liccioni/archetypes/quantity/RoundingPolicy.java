package net.liccioni.archetypes.quantity;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

@Value
public class RoundingPolicy {

    @Getter(AccessLevel.NONE)
    RoundingStrategy roundingStrategy;
    int numberOfDigits;
    @Getter(AccessLevel.NONE)
    int roundingDigit;
    double roundingStep;

    public BigDecimal round(final BigDecimal amount) {
        return roundingStrategy.round(amount, this);
    }
}
