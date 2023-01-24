package net.liccioni.archetypes.rule;

import java.util.List;
import java.util.Optional;

public class Rule {

    private final String name;

    private final List<RuleElement> elements;

    Rule(String name, List<RuleElement> elements) {
        this.name = name;
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public Proposition evaluate(RuleContext ruleContext) {
        RuleExecutionStack stack = new RuleExecutionStack(ruleContext);
        elements.forEach(stack::acceptElement);
        return Optional.ofNullable(stack.result()).orElseGet(() -> new Proposition("Evaluation Failed"));
    }
}