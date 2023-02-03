package net.liccioni.archetypes.quantity;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoundingStrategyTest {

    @Test
    void shouldRoundUpByStepExample() {
        final var policy = new RoundingPolicy(RoundingStrategy.ROUND_UP_BY_STEP, 2, 5, 0.05);
        final var actual = policy.round(new BigDecimal("3.1412"));
        assertThat(actual).isEqualTo(new BigDecimal("3.15"));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource(value = {"5,4.45,4.5", "6,4.45,4.4", "5,-4.45,-4.5", "6,-4.45,-4.4"}, delimiter = ',')
    void shouldRound(int roundingDigit, String value, String expected) {
        final var policy = new RoundingPolicy(RoundingStrategy.ROUND, 1, roundingDigit, 0.05);
        final var actual = policy.round(new BigDecimal(value));
        assertThat(actual).isEqualTo(new BigDecimal(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"4.45,4.5", "-4.45,-4.5"}, delimiter = ',')
    void shouldRoundUp(String value, String expected) {
        final var policy = new RoundingPolicy(RoundingStrategy.ROUND_UP, 1, 5, 0.05);
        final var actual = policy.round(new BigDecimal(value));
        assertThat(actual).isEqualTo(new BigDecimal(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"4.45,4.50", "-4.45,-4.50"}, delimiter = ',')
    void shouldRoundUpByStep(String value, String expected) {
        final var policy = new RoundingPolicy(RoundingStrategy.ROUND_UP_BY_STEP, 2, 5, 0.25);
        final var actual = policy.round(new BigDecimal(value));
        assertThat(actual).isEqualTo(new BigDecimal(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"4.45,4.5", "-4.45,-4.4"}, delimiter = ',')
    void shouldRoundTowardsPositive(String value, String expected) {
        final var policy = new RoundingPolicy(RoundingStrategy.ROUND_TOWARDS_POSITIVE, 1, 5, 0.25);
        final var actual = policy.round(new BigDecimal(value));
        assertThat(actual).isEqualTo(new BigDecimal(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"4.45,4.4", "-4.45,-4.4"}, delimiter = ',')
    void shouldRoundDown(String value, String expected) {
        final var policy = new RoundingPolicy(RoundingStrategy.ROUND_DOWN, 1, 5, 0.05);
        final var actual = policy.round(new BigDecimal(value));
        assertThat(actual).isEqualTo(new BigDecimal(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"4.45,4.25", "-4.45,-4.25"}, delimiter = ',')
    void shouldRoundDownByStep(String value, String expected) {
        final var policy = new RoundingPolicy(RoundingStrategy.ROUND_DOWN_BY_STEP, 2, 5, 0.25);
        final var actual = policy.round(new BigDecimal(value));
        assertThat(actual).isEqualTo(new BigDecimal(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"4.45,4.4", "-4.45,-4.5"}, delimiter = ',')
    void shouldRoundTowardsNegative(String value, String expected) {
        final var policy = new RoundingPolicy(RoundingStrategy.ROUND_TOWARDS_NEGATIVE, 1, 5, 0.25);
        final var actual = policy.round(new BigDecimal(value));
        assertThat(actual).isEqualTo(new BigDecimal(expected));
    }
}