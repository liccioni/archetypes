package net.liccioni.archetypes.product.price;


import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.Money;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleOverride;
import net.liccioni.archetypes.rule.RuleSet;

@Data
@SuperBuilder(toBuilder = true)
public class Price {

    @NonNull
    private final Money amount;
    private final TimeDate validFrom;
    private final TimeDate validTo;
    @Builder.Default
    private final RuleSet preConditions = new RuleSet("preConditions");

    public boolean isValid(RuleContext context, Set<RuleOverride> overrides) {
        final RuleSet transitConditions;
        if (!overrides.isEmpty()) {
            transitConditions = preConditions.toBuilder().build();
            overrides.forEach(transitConditions::addRuleOverride);
        } else {
            transitConditions = preConditions;
        }
        return transitConditions.evaluate(context);
    }
}
