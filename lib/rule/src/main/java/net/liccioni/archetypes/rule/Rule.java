package net.liccioni.archetypes.rule;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rule)) {
            return false;
        }
        Rule rule = (Rule) o;
        return name.equals(rule.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Rule{" +
                "name='" + name + '\'' +
                ", elements=" + elements.stream().map(Object::toString).collect(Collectors.joining(",")) +
                '}';
    }
}