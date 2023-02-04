package net.liccioni.archetypes.rule;

import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class Rule {

    private final String name;

    @Getter(AccessLevel.NONE)
    private final List<RuleElement> elements;

    Rule(String name, List<RuleElement> elements) {
        this.name = name;
        this.elements = elements;
    }

    public Proposition evaluate(RuleContext ruleContext) {
        RuleExecutionStack stack = new RuleExecutionStack(ruleContext);
        elements.forEach(stack::acceptElement);
        return Optional.ofNullable(stack.result()).orElseGet(() -> new Proposition("Evaluation Failed", false));
    }
}