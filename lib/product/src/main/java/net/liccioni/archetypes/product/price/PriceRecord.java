package net.liccioni.archetypes.product.price;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.Money;
import net.liccioni.archetypes.rule.RuleSet;

import java.util.Optional;

public record PriceRecord(@NonNull Money amount,
                          TimeDate validFrom,
                          TimeDate validTo,
                          RuleSet preConditions) implements Price {

    @Builder(toBuilder = true)
    public PriceRecord(@NonNull Money amount,
                       TimeDate validFrom,
                       TimeDate validTo,
                       RuleSet preConditions) {
        this.amount = amount;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.preConditions = Optional.ofNullable(preConditions).orElseGet(() -> RuleSet.builder().build());
    }

    @Override
    public Price setAmount(Money subtract) {
        return toBuilder().amount(subtract).build();
    }
}
