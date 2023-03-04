package net.liccioni.archetypes.inventory;


import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleSet;

@Value
@Builder(toBuilder = true)
public class RestockPolicy {

    @Builder.Default
    RuleSet ruleSet = RuleSet.builder().build();
    RuleContext ruleContext;
}
