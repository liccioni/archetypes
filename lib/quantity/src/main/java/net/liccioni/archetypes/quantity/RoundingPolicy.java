package net.liccioni.archetypes.quantity;

import java.math.BigDecimal;

public record RoundingPolicy(RoundingStrategy roundingStrategy,
                             int numberOfDigits,
                             int roundingDigit,
                             double roundingStep) {
    public BigDecimal round(final BigDecimal amount) {
        return roundingStrategy.round(amount, this);
    }
}
