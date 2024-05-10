package net.liccioni.archetypes.rule;


import static net.liccioni.archetypes.rule.Operator.AND;
import static net.liccioni.archetypes.rule.Operator.NOT;
import static net.liccioni.archetypes.rule.Operator.OR;
import static net.liccioni.archetypes.rule.Operator.XOR;

import lombok.Value;

public record Proposition(String name, boolean value) implements RuleElement {

    @Override
    public void acceptStack(RuleExecutionStack stack) {
        stack.acceptElement(this);
    }

    public Proposition and(Proposition other) {
        return newProposition(other.name(), AND, other.value && this.value);
    }

    public Proposition or(Proposition other) {
        return newProposition(other.name(), OR, other.value || this.value);
    }

    public Proposition xor(Proposition other) {
        return newProposition(other.name(), XOR, other.value ^ this.value);
    }

    public Proposition not() {
        return new Proposition(String.format("%s_%s", NOT.name(), this.name()), !this.value);
    }

    private Proposition newProposition(String otherName, Operator operator, boolean newValue) {
        return new Proposition(String.format("%s_%s_%s", otherName, operator.name(), this.name()), newValue);
    }
}
