package net.liccioni.archetypes.money;

import lombok.Builder;
import net.liccioni.archetypes.common.TimeDate;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Builder(toBuilder = true)
public record CurrencyConverter(Set<ExchangeRate> exchangeRates) {

    public Collection<ExchangeRate> getExchangeRates(Currency fromCurrency,
                                                     Currency toCurrency,
                                                     TimeDate from,
                                                     TimeDate to) {
        return this.exchangeRates.stream()
                .filter(p -> p.fromCurrency().isEqualTo(fromCurrency)
                        && p.toCurrency().isEqualTo(toCurrency)
                        && p.exchangeType().validFrom().value().isBefore(from.value())
                        && p.exchangeType().validTo().value().isAfter(to.value()))
                .collect(Collectors.toList());
    }

    public Collection<ExchangeType> exchangeRateTypes() {
        return this.exchangeRates.stream().map(ExchangeRate::exchangeType).collect(Collectors.toList());
    }

    public Money exchange(Money amount, Currency to, ExchangeRate rate) {
        if (amount.currency().isEqualTo(rate.fromCurrency()) && to.isEqualTo(rate.toCurrency())) {
            return new MoneyRecord(amount.multiply(rate.rate()).amount(), to);
        }
        throw new IllegalArgumentException(
                String.format("Invalid conversion from %s to %s at rate %s", amount, to, rate));
    }
}
