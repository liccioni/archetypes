package net.liccioni.archetypes.money;

import static java.time.ZoneOffset.UTC;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import lombok.val;
import net.liccioni.archetypes.common.TimeDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CurrencyConverterTest {

    private final Currency usd = ISOCurrency.builder().alphabeticCode("USD").build();
    private final Currency euro = ISOCurrency.builder().alphabeticCode("EUR").build();
    private final Currency gbp = ISOCurrency.builder().alphabeticCode("GBP").build();
    private final Clock testClock = Clock.fixed(Instant.parse("2023-01-26T10:22:47.353154Z"), UTC);
    private final Money hundredEuro = new MoneyRecord(100, euro);
    private final TimeDate oneMinuteAgo =
            TimeDate.builder().value(testClock.instant().minus(1, ChronoUnit.MINUTES)).build();
    private final TimeDate oneMinuteFromNow =
            TimeDate.builder().value(testClock.instant().plus(1, ChronoUnit.MINUTES)).build();

    @Test
    void shouldConvertMoney() {

        val euroUsdRateType = ExchangeType.builder().identifier("EURUSD")
                .validFrom(oneMinuteAgo)
                .validTo(oneMinuteFromNow).build();

        val euroUsdRate = ExchangeRate.builder()
                .rate(1.2)
                .fromCurrency(euro)
                .toCurrency(usd)
                .exchangeType(euroUsdRateType)
                .build();

        val converter = CurrencyConverter.builder().exchangeRates(Set.of(euroUsdRate)).build();
        val oneTwentyUsd = new MoneyRecord(120, usd);

        assertThat(converter.exchange(hundredEuro, usd, euroUsdRate)).isEqualTo(oneTwentyUsd);

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> converter.exchange(hundredEuro, gbp, euroUsdRate), "IllegalArgumentException was expected");
        Assertions.assertEquals(
                String.format("Invalid conversion from %s to %s at rate %s", hundredEuro, gbp, euroUsdRate),
                thrown.getMessage());
    }

    @Test
    void shouldGetExchangeRates() {

        val euroUsdRateType = ExchangeType.builder()
                .identifier("EURUSD")
                .validFrom(oneMinuteAgo)
                .validTo(oneMinuteFromNow).build();

        val euroUsdRate = ExchangeRate.builder()
                .rate(1.2)
                .fromCurrency(euro)
                .toCurrency(usd)
                .exchangeType(euroUsdRateType)
                .build();

        val converter = CurrencyConverter.builder().exchangeRates(Set.of(euroUsdRate)).build();

        val littleAfterOneMinuteAgo =
                TimeDate.builder().value(oneMinuteAgo.value().plus(1, ChronoUnit.MILLIS)).build();
        val littleBeforeOneMinuteFromNow =
                TimeDate.builder().value(oneMinuteFromNow.value().minus(1, ChronoUnit.MILLIS)).build();

        assertThat(converter.getExchangeRates(euro, usd, littleAfterOneMinuteAgo, littleBeforeOneMinuteFromNow))
                .containsExactly(euroUsdRate);

        assertThat(converter.getExchangeRates(euro, usd, oneMinuteAgo, littleBeforeOneMinuteFromNow))
                .isEmpty();

        assertThat(converter.getExchangeRates(euro, usd, littleAfterOneMinuteAgo, oneMinuteFromNow))
                .isEmpty();

        assertThat(converter.getExchangeRates(gbp, usd, littleAfterOneMinuteAgo, littleBeforeOneMinuteFromNow))
                .isEmpty();

        assertThat(converter.getExchangeRates(euro, gbp, littleAfterOneMinuteAgo, littleBeforeOneMinuteFromNow))
                .isEmpty();

        assertThat(converter.exchangeRateTypes()).containsExactly(euroUsdRateType);
    }
}