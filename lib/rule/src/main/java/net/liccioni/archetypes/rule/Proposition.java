package net.liccioni.archetypes.rule;


import static net.liccioni.archetypes.rule.Operator.AND;
import static net.liccioni.archetypes.rule.Operator.NOT;
import static net.liccioni.archetypes.rule.Operator.OR;
import static net.liccioni.archetypes.rule.Operator.XOR;

import lombok.Value;

@Value
public class Proposition implements RuleElement {

    String name;
    boolean value;

    @Override
    public void acceptStack(RuleExecutionStack stack) {
        stack.acceptElement(this);
    }

    public Proposition and(Proposition other) {
        return newProposition(other.getName(), AND, other.value && this.value);
    }

    public Proposition or(Proposition other) {
        return newProposition(other.getName(), OR, other.value || this.value);
    }

    public Proposition xor(Proposition other) {
        return newProposition(other.getName(), XOR, other.value ^ this.value);
    }

    public Proposition not() {
        return new Proposition(String.format("%s_%s", NOT.getName(), this.getName()), !this.value);
    }

    private Proposition newProposition(String otherName, Operator operator, boolean newValue) {
        return new Proposition(String.format("%s_%s_%s", otherName, operator.getName(), this.getName()), newValue);
    }
}
