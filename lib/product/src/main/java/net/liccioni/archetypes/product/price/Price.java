package net.liccioni.archetypes.product.price;


import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.Money;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleOverride;
import net.liccioni.archetypes.rule.RuleSet;

import java.util.Set;

public interface Price {

    //    @NonNull
    Money amount();

    TimeDate validFrom();

    TimeDate validTo();

    RuleSet preConditions();

    default boolean isValid(RuleContext context, Set<RuleOverride> overrides) {
        final RuleSet transitConditions;
        if (!overrides.isEmpty()) {
            transitConditions = preConditions().toBuilder().build();
            overrides.forEach(transitConditions::addRuleOverride);
        } else {
            transitConditions = preConditions();
        }
        return transitConditions.evaluate(context);
    }

    Price setAmount(Money subtract);
}
