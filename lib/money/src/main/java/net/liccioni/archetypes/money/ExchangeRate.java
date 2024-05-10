package net.liccioni.archetypes.money;

import lombok.Builder;
import lombok.NonNull;

@Builder(toBuilder = true)
public record ExchangeRate(@NonNull Double rate,
                           @NonNull ExchangeType exchangeType,
                           @NonNull Currency fromCurrency,
                           @NonNull Currency toCurrency) {

}
