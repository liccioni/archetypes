package net.liccioni.archetypes.quantity.money;

import static net.liccioni.archetypes.quantity.SIBaseUnit.METRE;
import static org.assertj.core.api.Assertions.assertThat;

import net.liccioni.archetypes.quantity.DerivedUnit;
import net.liccioni.archetypes.quantity.DerivedUnitTerm;
import net.liccioni.archetypes.quantity.Quantity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {

    private final ISOCurrency currencyPounds = new ISOCurrency("British Pound", "GBP");

    @Test
    void shouldCreateMoneyObject() {

        var threePounds = new Money(3, currencyPounds);
        var threeEuro = new Money(3, new ISOCurrency("Euro", "EUR"));
        var otherThreePounds = new Money(3, currencyPounds);
        var fivePounds = new Money(5, currencyPounds);
        assertThat(threePounds).isEqualTo(otherThreePounds);
        assertThat(threePounds).isNotEqualTo(fivePounds);
        assertThat(threePounds).isNotEqualTo(new Quantity(1, METRE));
        assertThat(threePounds).isNotEqualTo(threeEuro);
        assertThat(threePounds.getCurrency()).isEqualTo(currencyPounds);
    }

    @Test
    void shouldAddAndSubtractMoneySameCurrency() {
        var threePounds = new Money(3, currencyPounds);
        var fivePounds = new Money(5, currencyPounds);
        assertThat(threePounds.add(fivePounds)).isEqualTo(new Money(8, currencyPounds));
        assertThat(fivePounds.subtract(threePounds)).isEqualTo(new Money(2, currencyPounds));
    }

    @Test
    void shouldNotAddMoneySameCurrency() {
        var threePounds = new Money(3, currencyPounds);
        var fiveEuro = new Money(5, new ISOCurrency("Euro", "EUR"));
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> fiveEuro.subtract(threePounds), "IllegalArgumentException was expected");
        Assertions.assertEquals("Different units, cannot subtract " + fiveEuro + " and " + threePounds,
                thrown.getMessage());

        final var oneMetre = new Quantity(1, METRE);
        thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> fiveEuro.subtract(oneMetre), "IllegalArgumentException was expected");
        Assertions.assertEquals("Different units, cannot subtract " + fiveEuro + " and " + oneMetre,
                thrown.getMessage());
        System.out.println(threePounds);
    }

    @Test
    void shouldNotDivedMoney() {
        var threePounds = new Money(3, currencyPounds);
        var fiveEuro = new Money(5, new ISOCurrency("Euro", "EUR"));
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> fiveEuro.divide(threePounds), "IllegalArgumentException was expected");
        Assertions.assertEquals("Money cannot be divided by money " + fiveEuro + " / " + threePounds,
                thrown.getMessage());
        System.out.println(thrown.getMessage());
    }

    @Test
    void shouldDivedByOtherMetric() {
        var threePounds = new Money(30, currencyPounds);
        var fiveMetres = new Quantity(5, METRE);
        assertThat(threePounds.divide(fiveMetres)).isEqualTo(
                new Quantity(6, new DerivedUnit(currencyPounds, new DerivedUnitTerm(-1, METRE),
                        new DerivedUnitTerm(1, currencyPounds))));
    }

    @Test
    void shouldNotMultiplyMoney() {
        var threePounds = new Money(3, currencyPounds);
        var fiveEuro = new Money(5, new ISOCurrency("Euro", "EUR"));
        UnsupportedOperationException thrown = Assertions.assertThrows(UnsupportedOperationException.class,
                () -> fiveEuro.multiply(threePounds), "IllegalArgumentException was expected");
        Assertions.assertEquals("Money cannot be multiplied by anything " + fiveEuro + " * " + threePounds,
                thrown.getMessage());

        final var oneMetre = new Quantity(1, METRE);
        thrown = Assertions.assertThrows(UnsupportedOperationException.class,
                () -> fiveEuro.multiply(oneMetre), "IllegalArgumentException was expected");
        Assertions.assertEquals("Money cannot be multiplied by anything " + fiveEuro + " * " + oneMetre,
                thrown.getMessage());

    }
}