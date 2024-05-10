package net.liccioni.archetypes.product.price;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.Money;
import net.liccioni.archetypes.party.PartySignature;
import net.liccioni.archetypes.rule.RuleSet;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record ArbitraryPrice(@NonNull Money amount,
                             TimeDate validFrom,
                             TimeDate validTo,
                             RuleSet preConditions,
                             Set<PartySignature> approvedBy) implements Price {

    @Builder(toBuilder = true)
    public ArbitraryPrice(@NonNull Money amount,
                          TimeDate validFrom,
                          TimeDate validTo,
                          RuleSet preConditions,
                          Set<PartySignature> approvedBy) {
        this.amount = amount;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.preConditions = Optional.ofNullable(preConditions).orElseGet(() -> RuleSet.builder().build());
        this.approvedBy = Optional.ofNullable(approvedBy).orElseGet(HashSet::new);
    }

    @Override
    public Price setAmount(Money subtract) {
        return toBuilder().amount(subtract).build();
    }
}
