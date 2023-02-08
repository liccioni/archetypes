package net.liccioni.archetypes.money;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import net.liccioni.archetypes.common.TimeDate;

@Value
@Builder(toBuilder = true)
public class CurrencyConverter {

    @Builder.Default
    @Getter(value = AccessLevel.NONE)
    Set<ExchangeRate> exchangeRates = new HashSet<>();

    public Collection<ExchangeRate> getExchangeRates(Currency fromCurrency,
                                                     Currency toCurrency,
                                                     TimeDate from,
                                                     TimeDate to) {
        return this.exchangeRates.stream()
                .filter(p -> p.getFromCurrency().isEqualTo(fromCurrency)
                        && p.getToCurrency().isEqualTo(toCurrency)
                        && p.getExchangeType().getValidFrom().getValue().isBefore(from.getValue())
                        && p.getExchangeType().getValidTo().getValue().isAfter(to.getValue()))
                .collect(Collectors.toList());
    }

    public Collection<ExchangeType> exchangeRateTypes() {
        return this.exchangeRates.stream().map(ExchangeRate::getExchangeType).collect(Collectors.toList());
    }

    public Money exchange(Money amount, Currency to, ExchangeRate rate) {
        if (amount.getCurrency().isEqualTo(rate.getFromCurrency()) && to.isEqualTo(rate.getToCurrency())) {
            return new Money(amount.multiply(rate.getRate()).getAmount(), to);
        }
        throw new IllegalArgumentException(
                String.format("Invalid conversion from %s to %s at rate %s", amount, to, rate));
    }
}
