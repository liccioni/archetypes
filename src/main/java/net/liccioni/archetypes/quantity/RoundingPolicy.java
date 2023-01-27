package net.liccioni.archetypes.quantity;

import java.math.BigDecimal;

public class RoundingPolicy {

    private final RoundingStrategy roundingStrategy;

    private final int numberOfDigits;

    private final int roundingDigit;

    private final double roundingStep;

    public RoundingPolicy(final RoundingStrategy roundingStrategy,
                          final int numberOfDigits,
                          final int roundingDigit,
                          final double roundingStep) {
        this.roundingStrategy = roundingStrategy;
        this.numberOfDigits = numberOfDigits;
        this.roundingDigit = roundingDigit;
        this.roundingStep = roundingStep;
    }

    public RoundingStrategy getRoundingStrategy() {
        return roundingStrategy;
    }

    public int getNumberOfDigits() {
        return numberOfDigits;
    }

    public int getRoundingDigit() {
        return roundingDigit;
    }

    double getRoundingStep() {
        return roundingStep;
    }

    public BigDecimal round(final BigDecimal amount) {
        return roundingStrategy.round(amount, this);
    }
}
