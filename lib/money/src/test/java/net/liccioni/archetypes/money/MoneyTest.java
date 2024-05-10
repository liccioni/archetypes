package net.liccioni.archetypes.money;

import lombok.val;
import net.liccioni.archetypes.money.payment.PaymentRecord;
import net.liccioni.archetypes.quantity.DerivedUnit;
import net.liccioni.archetypes.quantity.DerivedUnitTerm;
import net.liccioni.archetypes.quantity.QuantityRecord;
import net.liccioni.archetypes.quantity.SIBaseUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    private final ISOCurrency currencyPounds =
            ISOCurrency.builder().name("British Pound").alphabeticCode("GBP").build();
    private final ISOCurrency euro = ISOCurrency.builder().name("Euro").alphabeticCode("EUR").build();

    @Test
    void shouldCreateMoneyObject() {

        var threePounds = new MoneyRecord(3, currencyPounds);
        var threeEuro = new MoneyRecord(3, euro);
        var otherThreePounds = new MoneyRecord(3, currencyPounds);
        var fivePounds = new MoneyRecord(5, currencyPounds);
        assertThat(threePounds).isEqualTo(otherThreePounds);
        assertThat(threePounds).isNotEqualTo(fivePounds);
        assertThat(threePounds).isNotEqualTo(new QuantityRecord(1, SIBaseUnit.METRE));
        assertThat(threePounds).isNotEqualTo(threeEuro);
        assertThat(threePounds.currency()).isEqualTo(currencyPounds);
    }

    @Test
    void shouldAddAndSubtractMoneySameCurrency() {
        var threePounds = new MoneyRecord(3, currencyPounds);
        var fivePounds = new MoneyRecord(5, currencyPounds);
        assertThat(threePounds.add(fivePounds)).isEqualTo(new MoneyRecord(8, currencyPounds));
        assertThat(fivePounds.subtract(threePounds)).isEqualTo(new MoneyRecord(2, currencyPounds));
    }

    @Test
    void shouldNotAddMoneyDifferentCurrency() {
        var threePounds = new MoneyRecord(3, currencyPounds);
        var fiveEuro = new MoneyRecord(5, euro);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> fiveEuro.subtract(threePounds), "IllegalArgumentException was expected");
        Assertions.assertEquals("Different units, cannot subtract " + fiveEuro + " and " + threePounds,
                thrown.getMessage());

        final var oneMetre = new QuantityRecord(1, SIBaseUnit.METRE);
        thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> fiveEuro.add(oneMetre), "IllegalArgumentException was expected");
        Assertions.assertEquals("Different units, cannot add " + fiveEuro + " and " + oneMetre,
                thrown.getMessage());
        System.out.println(threePounds);
    }

    @Test
    void shouldNotDivedMoney() {
        var threePounds = new MoneyRecord(3, currencyPounds);
        var fiveEuro = new MoneyRecord(5, euro);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> fiveEuro.divide(threePounds), "IllegalArgumentException was expected");
        Assertions.assertEquals("Money cannot be divided by money " + fiveEuro + " / " + threePounds,
                thrown.getMessage());
        System.out.println(thrown.getMessage());

        val somePayment = PaymentRecord.builder().amount(2).currency(euro).build();
        thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> fiveEuro.divide(somePayment), "IllegalArgumentException was expected");
        Assertions.assertEquals("Money cannot be divided by money " + fiveEuro + " / " + somePayment,
                thrown.getMessage());
        System.out.println(thrown.getMessage());
    }

    @Test
    void shouldDivedByOtherMetric() {
        var threePounds = new MoneyRecord(30, currencyPounds);
        var fiveMetres = new QuantityRecord(5, SIBaseUnit.METRE);
        assertThat(threePounds.divide(fiveMetres)).isEqualTo(
                new QuantityRecord(6, new DerivedUnit(currencyPounds, new DerivedUnitTerm(-1, SIBaseUnit.METRE),
                        new DerivedUnitTerm(1, currencyPounds))));
    }

    @Test
    void shouldNotMultiplyMoney() {
        var threePounds = new MoneyRecord(3, currencyPounds);
        var fiveEuro = new MoneyRecord(5, euro);
        UnsupportedOperationException thrown = Assertions.assertThrows(UnsupportedOperationException.class,
                () -> fiveEuro.multiply(threePounds), "IllegalArgumentException was expected");
        Assertions.assertEquals("Money cannot be multiplied by anything " + fiveEuro + " * " + threePounds,
                thrown.getMessage());

        final var oneMetre = new QuantityRecord(1, SIBaseUnit.METRE);
        thrown = Assertions.assertThrows(UnsupportedOperationException.class,
                () -> fiveEuro.multiply(oneMetre), "IllegalArgumentException was expected");
        Assertions.assertEquals("Money cannot be multiplied by anything " + fiveEuro + " * " + oneMetre,
                thrown.getMessage());

    }
}