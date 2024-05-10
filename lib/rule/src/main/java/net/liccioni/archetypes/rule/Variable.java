package net.liccioni.archetypes.rule;

import static net.liccioni.archetypes.rule.Operator.*;

public record Variable(String name, Comparable<?> value) implements RuleElement {

    public Variable(String name) {
        this(name, null);
    }

    @Override
    public void acceptStack(RuleExecutionStack stack) {
        stack.acceptElement(this);
    }

    public Proposition equalTo(Variable other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) == 0;
        return newProposition(newValue, other, EQUAL_TO);
    }

    public Proposition notEqualTo(Variable other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) != 0;
        return newProposition(newValue, other, NOT_EQUAL_TO);
    }

    public Proposition greaterThan(Variable other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) > 0;
        return newProposition(newValue, other, GREATER_THAN);
    }

    public Proposition lessThan(Variable other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) < 0;
        return newProposition(newValue, other, LESS_THAN);
    }

    public Proposition greaterThanOrEqualTo(Variable other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) >= 0;
        return newProposition(newValue, other, GREATER_THAN_OR_EQUAL_TO);
    }

    public Proposition lessThanOrEqualTo(Variable other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) <= 0;
        return newProposition(newValue, other, LESS_THAN_OR_EQUAL_TO);
    }

    @SuppressWarnings("unchecked")
    private int compareTo(Object value) {
        return ((Comparable<Object>) this.value).compareTo(value);
    }

    boolean isAssignableFrom(Variable other) {
        return other.value.getClass().isAssignableFrom(this.value.getClass());
    }

    Proposition newProposition(boolean newValue, Variable other, Operator operator) {
        return new Proposition(String.format("%s_%s_%s", other.name(), operator.name(), this.name()), newValue);
    }
}
