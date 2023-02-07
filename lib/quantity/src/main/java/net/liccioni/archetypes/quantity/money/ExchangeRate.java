package net.liccioni.archetypes.quantity.money;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class ExchangeRate {
    @NonNull
    Double rate;
    @NonNull
    ExchangeType exchangeType;
    @NonNull
    Currency fromCurrency;
    @NonNull
    Currency toCurrency;
}
