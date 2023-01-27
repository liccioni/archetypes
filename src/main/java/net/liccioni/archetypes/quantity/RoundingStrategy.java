package net.liccioni.archetypes.quantity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;

public enum RoundingStrategy {
    ROUND(RoundingStrategy::roundNormal),
    ROUND_UP(RoundingStrategy::roundUp),
    ROUND_UP_BY_STEP(RoundingStrategy::roundUpByStep),
    ROUND_TOWARDS_POSITIVE(RoundingStrategy::roundTowardsPositive),
    ROUND_DOWN(RoundingStrategy::roundDown),
    ROUND_DOWN_BY_STEP(RoundingStrategy::roundDownByStep),
    ROUND_TOWARDS_NEGATIVE(RoundingStrategy::roundTowardsNegative);

    private final BiFunction<BigDecimal, RoundingPolicy, BigDecimal> roundFunc;

    RoundingStrategy(final BiFunction<BigDecimal, RoundingPolicy, BigDecimal> roundFunc) {
        this.roundFunc = roundFunc;
    }

    BigDecimal round(final BigDecimal amount, RoundingPolicy policy) {
        return this.roundFunc.apply(amount, policy);
    }

    private static BigDecimal roundUp(BigDecimal amount, RoundingPolicy policy) {
        return amount.setScale(policy.getNumberOfDigits(), RoundingMode.UP);
    }

    private static BigDecimal roundUpByStep(BigDecimal amount, RoundingPolicy policy) {
        final var increment = BigDecimal.valueOf(policy.getRoundingStep());
        var divided = amount.divide(increment, 0, RoundingMode.UP);
        return divided.multiply(increment);
    }

    private static BigDecimal roundDownByStep(BigDecimal amount, RoundingPolicy policy) {
        final var increment = BigDecimal.valueOf(policy.getRoundingStep());
        var divided = amount.divide(increment, 0, RoundingMode.DOWN);
        return divided.multiply(increment);
    }

    private static BigDecimal roundTowardsPositive(BigDecimal amount, RoundingPolicy policy) {
        return amount.setScale(policy.getNumberOfDigits(), RoundingMode.CEILING);
    }

    private static BigDecimal roundDown(BigDecimal amount, RoundingPolicy policy) {
        return amount.setScale(policy.getNumberOfDigits(), RoundingMode.DOWN);
    }

    private static BigDecimal roundTowardsNegative(BigDecimal amount, RoundingPolicy policy) {
        return amount.setScale(policy.getNumberOfDigits(), RoundingMode.FLOOR);
    }

    private static BigDecimal roundNormal(BigDecimal amount, RoundingPolicy policy) {
        return null;
    }
}
