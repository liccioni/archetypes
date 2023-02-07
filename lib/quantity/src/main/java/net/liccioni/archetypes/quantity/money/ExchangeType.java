package net.liccioni.archetypes.quantity.money;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleSet;

@Value
@Builder(toBuilder = true)
public class ExchangeType {

    @NonNull
    String identifier;
    String description;
    @NonNull
    TimeDate validFrom;
    @NonNull
    TimeDate validTo;
    @Builder.Default
    RuleSet applicabilityRules = new RuleSet("applicabilityRules");

    public boolean isApplicable(RuleContext context) {
        return applicabilityRules.evaluate(context);
    }
}
