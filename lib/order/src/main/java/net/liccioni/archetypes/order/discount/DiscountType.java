package net.liccioni.archetypes.order.discount;


import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleSet;

@Value
@Builder(toBuilder = true)
public class DiscountType {

    @Builder.Default
    RuleSet ruleSet = RuleSet.builder().build();

    public boolean getDiscount(RuleContext context) {

        return ruleSet.evaluate(context);
    }
}
