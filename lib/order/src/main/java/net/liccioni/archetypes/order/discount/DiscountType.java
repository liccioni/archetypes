package net.liccioni.archetypes.order.discount;

import lombok.Builder;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleSet;

import java.util.Optional;

public record DiscountType(RuleSet ruleSet) {

    @Builder(toBuilder = true)
    public DiscountType(RuleSet ruleSet) {
        this.ruleSet = Optional.ofNullable(ruleSet).orElseGet(() -> RuleSet.builder().build());
    }

    public boolean getDiscount(RuleContext context) {

        return ruleSet.evaluate(context);
    }
}
