package net.liccioni.archetypes.quantity;

import static net.liccioni.archetypes.quantity.SIBaseUnit.CANDELA;
import static net.liccioni.archetypes.quantity.SIBaseUnit.METRE;
import static net.liccioni.archetypes.quantity.SIBaseUnit.SECOND;
import static net.liccioni.archetypes.quantity.SystemOfUnits.INTERNATIONAL_SYSTEM_OF_UNITS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnitConverterTest {

    private final SimpleUnit km = new SimpleUnit("Kilometre", "km", "length", INTERNATIONAL_SYSTEM_OF_UNITS);
    private final SimpleUnit hour = new SimpleUnit("hour", "h", "time", INTERNATIONAL_SYSTEM_OF_UNITS);
    private final DerivedUnit kmPerHour =
            new DerivedUnit(INTERNATIONAL_SYSTEM_OF_UNITS, new DerivedUnitTerm(-1, hour), new DerivedUnitTerm(1, km));
    private final DerivedUnit mPerSecond =
            new DerivedUnit(INTERNATIONAL_SYSTEM_OF_UNITS, new DerivedUnitTerm(-1, SECOND),
                    new DerivedUnitTerm(1, METRE));
    private final RoundingPolicy roundingPolicy = new RoundingPolicy(RoundingStrategy.ROUND_UP, 5, 5, 1);
    private final RoundingPolicy simple = new RoundingPolicy(RoundingStrategy.ROUND_UP, 1, 5, 1);

//    {
//        kmPerHour.addTerm(new DerivedUnitTerm(-1, hour));
//        kmPerHour.addTerm(new DerivedUnitTerm(1, km));
//        mPerSecond.addTerm(new DerivedUnitTerm(-1, SECOND));
//        mPerSecond.addTerm(new DerivedUnitTerm(1, METRE));
//    }

    private final StandardConversion kmTom = new StandardConversion(km, METRE, 0.001);
    private final StandardConversion mToKm = new StandardConversion(METRE, km, 1000);
    private final StandardConversion kmPerHrToMetrePerSecond = new StandardConversion(kmPerHour, mPerSecond, 1 / 3.6);

    @Test
    void shouldConvertFromMetreToKilometre() {

        var unitConverter = new UnitConverter();
        unitConverter.addConverter(this.mToKm);
        final var actual = unitConverter.convert(new Quantity(1, METRE), km).round(simple);
        Quantity expected = new Quantity(1000, km);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldConvertFromKilometreToMetre() {

        var unitConverter = new UnitConverter();
        unitConverter.addConverter(mToKm);
        unitConverter.addConverter(kmTom);
        final var actual = unitConverter.convert(new Quantity(1000, km), METRE).round(simple);
        Quantity expected = new Quantity(1, METRE);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldConvertFromKilometrePerHourToMetrePerSecond() {

        var unitConverter = new UnitConverter();
        unitConverter.addConverter(kmPerHrToMetrePerSecond);
        final var roundingPolicy = new RoundingPolicy(RoundingStrategy.ROUND_UP, 5, 5, 1);
        final var actual = unitConverter.convert(new Quantity(60, kmPerHour), mPerSecond).round(roundingPolicy);
        Quantity expected = new Quantity(16.66667, mPerSecond);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldExpectCannotFindConverterException() {

        var unitConverter = new UnitConverter();
        unitConverter.addConverter(mToKm);
        unitConverter.removeConverter(mToKm);
        IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> unitConverter.convert(new Quantity(1, METRE), km), "IllegalStateException was expected");

        Assertions.assertEquals(
                "Cannot find converter for Unit{name='metre', symbol='m', definition='length', " +
                        "systemOfUnits=INTERNATIONAL_SYSTEM_OF_UNITS}  to Unit{name='Kilometre', symbol='km', " +
                        "definition='length', systemOfUnits=INTERNATIONAL_SYSTEM_OF_UNITS}",
                thrown.getMessage());

    }

    @Test
    void shouldConvertChooseRightConverter() {
        var unitConverter = new UnitConverter();
        var wrongConverter = new StandardConversion(kmPerHour, CANDELA, 0.009);
        unitConverter.addConverter(wrongConverter);
        unitConverter.addConverter(kmPerHrToMetrePerSecond);
        final var actual = unitConverter.convert(new Quantity(60, kmPerHour), mPerSecond).round(roundingPolicy);
        Quantity expected = new Quantity(16.66667, mPerSecond);
        assertThat(actual).isEqualTo(expected);
    }
}