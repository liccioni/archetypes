package net.liccioni.archetypes.relationship;


import lombok.Builder;
import net.liccioni.archetypes.rule.RuleContext;

import java.util.Optional;

public record Capabilities(RuleContext ruleContext) {

    @Builder(toBuilder = true)
    public Capabilities(RuleContext ruleContext) {
        this.ruleContext = Optional.ofNullable(ruleContext).orElseGet(() -> RuleContext.builder().name("").build());
    }
}
