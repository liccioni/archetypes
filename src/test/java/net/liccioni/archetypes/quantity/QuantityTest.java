package net.liccioni.archetypes.quantity;

import static net.liccioni.archetypes.quantity.SIBaseUnit.METRE;
import static net.liccioni.archetypes.quantity.SIBaseUnit.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuantityTest {

    @Test
    void shouldAddQuantitySameMetric() {

        Quantity actual = new Quantity(3, METRE).add(new Quantity(2, METRE));
        Quantity expected = new Quantity(5, METRE);
        assertThat(actual).isEqualTo(expected);
        System.out.println(actual);
    }

    @Test
    void shouldExpectExceptionWhenAddingQuantitiesDifferentMetric() {

        final var qa = new Quantity(3, METRE);
        final var qb = new Quantity(2, SECOND);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> qa.add(qb), "IllegalArgumentException was expected");
        Assertions.assertEquals("Different units, cannot add " + qa + " and " + qb, thrown.getMessage());
    }

    @Test
    void shouldSubtractQuantitySameMetric() {

        Quantity actual = new Quantity(3, METRE).subtract(new Quantity(2, METRE));
        Quantity expected = new Quantity(1, METRE);
        assertThat(actual).isEqualTo(expected);
        System.out.println(actual);
    }

    @Test
    void shouldExpectExceptionWhenSubtractingQuantitiesDifferentMetric() {

        final var qa = new Quantity(3, METRE);
        final var qb = new Quantity(2, SECOND);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> qa.subtract(qb), "IllegalArgumentException was expected");
        Assertions.assertEquals("Different units, cannot subtract " + qa + " and " + qb, thrown.getMessage());
    }

    @Test
    void shouldMultiplyQuantityByFactor() {

        Quantity actual =
                new Quantity(3, METRE).multiply(8);
        Quantity expected = new Quantity(new BigDecimal("24.00"), METRE);
        assertThat(actual).isEqualTo(expected);
        System.out.println(actual);
    }

    @Test
    void shouldMultiplyQuantitySameMetric() {

        Quantity actual =
                new Quantity(3, METRE).multiply(new Quantity(5, METRE));
        final var squareMetre = new DerivedUnit(SystemOfUnits.INTERNATIONAL_SYSTEM_OF_UNITS);
        squareMetre.addTerm(new DerivedUnitTerm(2, METRE));
        Quantity expected = new Quantity(new BigDecimal("15.00"), squareMetre);
        assertThat(actual).isEqualTo(expected);
        System.out.println(actual);
    }

    @Test
    void shouldMultiplyQuantityDifferentMetric() {

        Quantity actual =
                new Quantity(3, METRE).multiply(new Quantity(5, SECOND));
        final var metreAndSecond = new DerivedUnit(SystemOfUnits.INTERNATIONAL_SYSTEM_OF_UNITS);
        metreAndSecond.addTerm(new DerivedUnitTerm(1, METRE));
        metreAndSecond.addTerm(new DerivedUnitTerm(1, SECOND));
        Quantity expected = new Quantity(new BigDecimal("15.00"), metreAndSecond);
        assertThat(actual).isEqualTo(expected);
        System.out.println(actual);
    }

    @Test
    void shouldMultiplyQuantitySameMetricDerived() {

        final var squareMetre = new DerivedUnit(SystemOfUnits.INTERNATIONAL_SYSTEM_OF_UNITS);
        squareMetre.addTerm(new DerivedUnitTerm(2, METRE));
        final var cubeMetre = new DerivedUnit(SystemOfUnits.INTERNATIONAL_SYSTEM_OF_UNITS);
        cubeMetre.addTerm(new DerivedUnitTerm(3, METRE));
        Quantity expected = new Quantity(new BigDecimal("30.000"), cubeMetre);
        Quantity actual = new Quantity(3, METRE).multiply(new Quantity(5, METRE))
                .multiply(new Quantity(2, METRE));
        assertThat(actual).isEqualTo(expected);
        System.out.println(actual);
    }

    @Test
    void shouldDivideQuantityByFactor() {

        Quantity actual =
                new Quantity(32, METRE).divide(8);
        Quantity expected = new Quantity(new BigDecimal("4.0"), METRE);
        assertThat(actual).isEqualTo(expected);
        System.out.println(actual);
    }

    @Test
    void shouldDivideQuantitySameMetricAndPowers() {
        Quantity actual = new Quantity(15, METRE).divide(new Quantity(3, METRE));
        Quantity expected =
                new Quantity(new BigDecimal("5.0"), new DerivedUnit(SystemOfUnits.INTERNATIONAL_SYSTEM_OF_UNITS));
        assertThat(actual).isEqualTo(expected);
        System.out.println(actual);
    }

    @Test
    void shouldDivideQuantityDifferentMetricPowers() {
        final var squareMetre = new DerivedUnit(SystemOfUnits.INTERNATIONAL_SYSTEM_OF_UNITS);
        squareMetre.addTerm(new DerivedUnitTerm(2, METRE));
        Quantity actual = new Quantity(15, squareMetre).divide(new Quantity(3, METRE));
        Quantity expected = new Quantity(new BigDecimal("15.0"), METRE);
        assertThat(new Quantity(10, METRE).add(actual)).isEqualTo(expected);
        System.out.println(actual);
    }

    @Test
    void shouldDivideQuantityDifferentMetrics() {
        final var metrePerSecond = new DerivedUnit(SystemOfUnits.INTERNATIONAL_SYSTEM_OF_UNITS);
        metrePerSecond.addTerm(new DerivedUnitTerm(1, METRE));
        metrePerSecond.addTerm(new DerivedUnitTerm(-1, SECOND));
        Quantity actual = new Quantity(15, METRE).divide(new Quantity(3, SECOND));
        Quantity expected = new Quantity(new BigDecimal("5.0"), metrePerSecond);
        assertThat(actual).isEqualTo(expected);
        System.out.println(actual);
    }

    @Test
    void shouldDivideQuantityDifferentMetricsAndPowers() {
        final var metrePerSecond = new DerivedUnit(SystemOfUnits.INTERNATIONAL_SYSTEM_OF_UNITS);
        metrePerSecond.addTerm(new DerivedUnitTerm(1, METRE));
        metrePerSecond.addTerm(new DerivedUnitTerm(-2, SECOND));
        Quantity actual = new Quantity(15, METRE).divide(new Quantity(3, SECOND))
                .divide(new Quantity(3, SECOND));
        Quantity expected = new Quantity(new BigDecimal("1.7"), metrePerSecond);
        assertThat(actual).isEqualTo(expected);
        System.out.println(actual);
    }

    @Test
    void voidShouldCompareQuantitiesSameMetric() {
        var oneMetre = new Quantity(1, METRE);
        var twoMetre = new Quantity(2, METRE);
        assertThat(oneMetre.equalTo(twoMetre)).isFalse();
        assertThat(oneMetre.equalTo(new Quantity(1, SECOND))).isFalse();
        assertThat(twoMetre.equalTo(new Quantity(2, METRE))).isTrue();
        assertThat(oneMetre.lessThan(twoMetre)).isTrue();
        assertThat(oneMetre.greaterThan(twoMetre)).isFalse();
    }
}