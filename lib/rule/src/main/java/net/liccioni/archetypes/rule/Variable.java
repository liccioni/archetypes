package net.liccioni.archetypes.rule;

import static net.liccioni.archetypes.rule.Operator.EQUAL_TO;
import static net.liccioni.archetypes.rule.Operator.GREATER_THAN;
import static net.liccioni.archetypes.rule.Operator.GREATER_THAN_OR_EQUAL_TO;
import static net.liccioni.archetypes.rule.Operator.LESS_THAN;
import static net.liccioni.archetypes.rule.Operator.LESS_THAN_OR_EQUAL_TO;
import static net.liccioni.archetypes.rule.Operator.NOT_EQUAL_TO;

import lombok.Data;
import lombok.ToString;

@Data
public class Variable<T> implements RuleElement {
    private final T value;
    @ToString.Exclude
    private final Class<?> type;
    private final String name;

    public Variable(String name) {
        this.name = name;
        this.value = null;
        this.type = null;
    }

    public Variable(String name, T value) {
        this.name = name;
        this.value = value;
        this.type = value.getClass();
    }

    @Override
    public void acceptStack(RuleExecutionStack stack) {
        stack.acceptElement(this);
    }

    public Proposition equalTo(Variable<?> other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) == 0;
        return newProposition(newValue, other, EQUAL_TO);
    }

    public Proposition notEqualTo(Variable<?> other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) != 0;
        return newProposition(newValue, other, NOT_EQUAL_TO);
    }

    public Proposition greaterThan(Variable<?> other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) > 0;
        return newProposition(newValue, other, GREATER_THAN);
    }

    public Proposition lessThan(Variable<?> other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) < 0;
        return newProposition(newValue, other, LESS_THAN);
    }

    public Proposition greaterThanOrEqualTo(Variable<?> other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) >= 0;
        return newProposition(newValue, other, GREATER_THAN_OR_EQUAL_TO);
    }

    public Proposition lessThanOrEqualTo(Variable<?> other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) <= 0;
        return newProposition(newValue, other, LESS_THAN_OR_EQUAL_TO);
    }

    @SuppressWarnings("unchecked")
    private int compareTo(Object value) {
        return ((Comparable<T>) this.value).compareTo((T) value);
    }

    protected boolean isAssignableFrom(Variable<?> other) {
        return other.type.isAssignableFrom(this.type);
    }

    protected Proposition newProposition(boolean newValue, Variable<?> other, Operator operator) {
        return new Proposition(String.format("%s_%s_%s", other.getName(), operator.getName(), this.getName()),
                newValue);
    }
}
