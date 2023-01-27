package net.liccioni.archetypes.quantity;

import static net.liccioni.archetypes.quantity.SIBaseUnit.METRE;
import static net.liccioni.archetypes.quantity.SIBaseUnit.SECOND;
import static net.liccioni.archetypes.quantity.SystemOfUnits.INTERNATIONAL_SYSTEM_OF_UNITS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UnitConverterTest {

    @Test
    void shouldConvertFromMetreToKilometre() {
        var km = new DerivedUnit("Kilometre", "km", "length", INTERNATIONAL_SYSTEM_OF_UNITS);
        km.addTerm(new DerivedUnitTerm(1, METRE));
        var mToKm = new StandardConversion(METRE, km, 1000);
        var unitConverter = new UnitConverter();
        unitConverter.addConverter(mToKm);
        final var actual = unitConverter.convert(new Quantity(1, METRE), km);
        Quantity expected = new Quantity(1000, km);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldConvertFromKilometreToMetre() {
        var km = new DerivedUnit("Kilometre", "km", "length", INTERNATIONAL_SYSTEM_OF_UNITS);
        km.addTerm(new DerivedUnitTerm(1, METRE));
        var mToKm = new StandardConversion(METRE, km, 1000);
        var kmTom = new StandardConversion(km, METRE, 0.001);
        var unitConverter = new UnitConverter();
        unitConverter.addConverter(mToKm);
        unitConverter.addConverter(kmTom);
        final var actual = unitConverter.convert(new Quantity(1000, km), METRE);
        Quantity expected = new Quantity(1, METRE);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldConvertFromKilometrePerHourToMetrePerSecond() {
        var km = new DerivedUnit("Kilometre", "km", "length", INTERNATIONAL_SYSTEM_OF_UNITS);
        km.addTerm(new DerivedUnitTerm(1, km));
        var hour = new DerivedUnit("hour", "h", "time", INTERNATIONAL_SYSTEM_OF_UNITS);
        hour.addTerm(new DerivedUnitTerm(1, hour));

        var kmPerHour = new DerivedUnit("Kilometre per Hour", "km/h", "velocity", INTERNATIONAL_SYSTEM_OF_UNITS);
        kmPerHour.addTerm(new DerivedUnitTerm(-1, hour));
        kmPerHour.addTerm(new DerivedUnitTerm(1, km));

        var mPerSecond = new DerivedUnit("Metre per Second", "m/s", "velocity", INTERNATIONAL_SYSTEM_OF_UNITS);
        mPerSecond.addTerm(new DerivedUnitTerm(-1, SECOND));
        mPerSecond.addTerm(new DerivedUnitTerm(1, METRE));

        var kmPerHrToMetrePerSecond = new StandardConversion(kmPerHour, mPerSecond, 1 / 3.6);
        var unitConverter = new UnitConverter();
        unitConverter.addConverter(kmPerHrToMetrePerSecond);
        final var roundingPolicy = new RoundingPolicy(RoundingStrategy.ROUND_UP, 5, 5, 1);
        final var actual = unitConverter.convert(new Quantity(60, kmPerHour), mPerSecond).round(roundingPolicy);
        Quantity expected = new Quantity(16.66667, mPerSecond);
        assertThat(actual).isEqualTo(expected);
    }
}