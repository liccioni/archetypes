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
    }


    @Test
    void shouldMultiplyQuantitySameMetric() {

        Quantity actual =
                new Quantity(3, METRE).multiply(new Quantity(5, METRE));
        final var squareMetre = new DerivedUnit(SystemOfUnits.INTERNATIONAL_SYSTEM_OF_UNITS);
        squareMetre.addTerm(new DerivedUnitTerm(2, METRE));
        Quantity expected = new Quantity(new BigDecimal("15.00"), squareMetre);
        assertThat(actual).isEqualTo(expected);
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
    }

    @Test
    void shouldMultiplyQuantitySameMetricDerived() {

        final var squareMetre = new DerivedUnit(SystemOfUnits.INTERNATIONAL_SYSTEM_OF_UNITS);
        squareMetre.addTerm(new DerivedUnitTerm(2, METRE));
        final var cubeMetre = new DerivedUnit(SystemOfUnits.INTERNATIONAL_SYSTEM_OF_UNITS);
        cubeMetre.addTerm(new DerivedUnitTerm(3, METRE));
        Quantity expected = new Quantity(new BigDecimal("30.000"), cubeMetre);
        Quantity firstTime =
                new Quantity(3, METRE).multiply(new Quantity(5, METRE));
        Quantity actual = firstTime.multiply(new Quantity(2, METRE));
        assertThat(actual).isEqualTo(expected);
    }
}