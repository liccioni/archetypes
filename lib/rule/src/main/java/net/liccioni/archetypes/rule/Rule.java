package net.liccioni.archetypes.rule;

import java.util.List;
import java.util.Optional;

public record Rule(String name, List<RuleElement> elements) {

    public Proposition evaluate(RuleContext ruleContext) {
        RuleExecutionStack stack = new RuleExecutionStack(ruleContext);
        elements.forEach(stack::acceptElement);
        return Optional.ofNullable(stack.result()).orElseGet(() -> new Proposition("Evaluation Failed", false));
    }
}