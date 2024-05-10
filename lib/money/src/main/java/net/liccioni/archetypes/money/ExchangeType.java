package net.liccioni.archetypes.money;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleSet;

import java.util.Optional;

@Builder(toBuilder = true)
public record ExchangeType(@NonNull String identifier,
                           String description,
                           @NonNull TimeDate validFrom,
                           @NonNull TimeDate validTo,
                           RuleSet applicabilityRules) {

    public ExchangeType(@NonNull String identifier,
                        String description,
                        @NonNull TimeDate validFrom,
                        @NonNull TimeDate validTo,
                        RuleSet applicabilityRules) {
        this.identifier = identifier;
        this.description = description;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.applicabilityRules = Optional.ofNullable(applicabilityRules).orElseGet(() -> new RuleSet("applicabilityRules"));
    }

    public boolean isApplicable(RuleContext context) {
        return applicabilityRules.evaluate(context);
    }
}
