package net.liccioni.archetypes.order;

import static org.assertj.core.api.Assertions.assertThat;

import net.liccioni.archetypes.money.ISOCurrency;
import net.liccioni.archetypes.money.Money;
import net.liccioni.archetypes.money.MoneyRecord;
import net.liccioni.archetypes.order.discount.MonetaryDiscount;
import net.liccioni.archetypes.order.discount.PercentageDiscount;
import net.liccioni.archetypes.product.price.Price;
import net.liccioni.archetypes.product.price.PriceRecord;
import org.junit.jupiter.api.Test;

class DiscountTest {

    @Test
    void shouldCalculateMonetaryDiscount() {
        var monetaryDiscount = MonetaryDiscount.builder().amount(2.0).build();
        final var eur = ISOCurrency.builder().alphabeticCode("EUR").build();
        final var tenEuro = PriceRecord.builder().amount(MoneyRecord.moneyBuilder().amount(10).currency(eur).build()).build();
        final var actual = monetaryDiscount.calculateDiscountedPrice(tenEuro);
        final var eightEuro = PriceRecord.builder().amount(MoneyRecord.moneyBuilder().amount(8).currency(eur).build()).build();
        assertThat(actual).isEqualTo(eightEuro);
    }

    @Test
    void shouldCalculatePercentageDiscount() {
        var monetaryDiscount = PercentageDiscount.builder().percentage(5.0).build();
        final var eur = ISOCurrency.builder().alphabeticCode("EUR").build();
        final var hundredEuro = PriceRecord.builder().amount(MoneyRecord.moneyBuilder().amount(100).currency(eur).build()).build();
        final var actual = monetaryDiscount.calculateDiscountedPrice(hundredEuro);
        final var ninetyFiveEuro = PriceRecord.builder().amount(MoneyRecord.moneyBuilder().amount(95).currency(eur).build()).build();
        assertThat(actual).isEqualTo(ninetyFiveEuro);
    }
}