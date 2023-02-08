package net.liccioni.archetypes.money;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.val;
import net.liccioni.archetypes.money.payment.Payment;
import net.liccioni.archetypes.quantity.DerivedUnit;
import net.liccioni.archetypes.quantity.DerivedUnitTerm;
import net.liccioni.archetypes.quantity.Quantity;
import net.liccioni.archetypes.quantity.SIBaseUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {

    private final ISOCurrency currencyPounds =
            ISOCurrency.builder().name("British Pound").alphabeticCode("GBP").build();
    private final ISOCurrency euro = ISOCurrency.builder().name("Euro").alphabeticCode("EUR").build();

    @Test
    void shouldCreateMoneyObject() {

        var threePounds = new Money(3, currencyPounds);
        var threeEuro = new Money(3, euro);
        var otherThreePounds = new Money(3, currencyPounds);
        var fivePounds = new Money(5, currencyPounds);
        assertThat(threePounds).isEqualTo(otherThreePounds);
        assertThat(threePounds).isNotEqualTo(fivePounds);
        assertThat(threePounds).isNotEqualTo(new Quantity(1, SIBaseUnit.METRE));
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
    void shouldNotAddMoneyDifferentCurrency() {
        var threePounds = new Money(3, currencyPounds);
        var fiveEuro = new Money(5, euro);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> fiveEuro.subtract(threePounds), "IllegalArgumentException was expected");
        Assertions.assertEquals("Different units, cannot subtract " + fiveEuro + " and " + threePounds,
                thrown.getMessage());

        final var oneMetre = new Quantity(1, SIBaseUnit.METRE);
        thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> fiveEuro.add(oneMetre), "IllegalArgumentException was expected");
        Assertions.assertEquals("Different units, cannot add " + fiveEuro + " and " + oneMetre,
                thrown.getMessage());
        System.out.println(threePounds);
    }

    @Test
    void shouldNotDivedMoney() {
        var threePounds = new Money(3, currencyPounds);
        var fiveEuro = new Money(5, euro);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> fiveEuro.divide(threePounds), "IllegalArgumentException was expected");
        Assertions.assertEquals("Money cannot be divided by money " + fiveEuro + " / " + threePounds,
                thrown.getMessage());
        System.out.println(thrown.getMessage());

        val somePayment = Payment.paymentBuilder().amount(2).currency(euro).build();
        thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> fiveEuro.divide(somePayment), "IllegalArgumentException was expected");
        Assertions.assertEquals("Money cannot be divided by money " + fiveEuro + " / " + somePayment,
                thrown.getMessage());
        System.out.println(thrown.getMessage());
    }

    @Test
    void shouldDivedByOtherMetric() {
        var threePounds = new Money(30, currencyPounds);
        var fiveMetres = new Quantity(5, SIBaseUnit.METRE);
        assertThat(threePounds.divide(fiveMetres)).isEqualTo(
                new Quantity(6, new DerivedUnit(currencyPounds, new DerivedUnitTerm(-1, SIBaseUnit.METRE),
                        new DerivedUnitTerm(1, currencyPounds))));
    }

    @Test
    void shouldNotMultiplyMoney() {
        var threePounds = new Money(3, currencyPounds);
        var fiveEuro = new Money(5, euro);
        UnsupportedOperationException thrown = Assertions.assertThrows(UnsupportedOperationException.class,
                () -> fiveEuro.multiply(threePounds), "IllegalArgumentException was expected");
        Assertions.assertEquals("Money cannot be multiplied by anything " + fiveEuro + " * " + threePounds,
                thrown.getMessage());

        final var oneMetre = new Quantity(1, SIBaseUnit.METRE);
        thrown = Assertions.assertThrows(UnsupportedOperationException.class,
                () -> fiveEuro.multiply(oneMetre), "IllegalArgumentException was expected");
        Assertions.assertEquals("Money cannot be multiplied by anything " + fiveEuro + " * " + oneMetre,
                thrown.getMessage());

    }
}