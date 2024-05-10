package net.liccioni.archetypes.inventory;


import lombok.Builder;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleSet;

import java.util.Optional;

public record RestockPolicy(RuleSet ruleSet, RuleContext ruleContext) {

    @Builder(toBuilder = true)
    public RestockPolicy(RuleSet ruleSet, RuleContext ruleContext) {
        this.ruleSet = Optional.ofNullable(ruleSet).orElseGet(() -> RuleSet.builder().build());
        this.ruleContext = ruleContext;
    }
}
