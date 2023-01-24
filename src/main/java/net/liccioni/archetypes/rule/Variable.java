package net.liccioni.archetypes.rule;

import static net.liccioni.archetypes.rule.Operation.EQUAL_TO;
import static net.liccioni.archetypes.rule.Operation.GREATER_THAN;
import static net.liccioni.archetypes.rule.Operation.GREATER_THAN_OR_EQUAL_TO;
import static net.liccioni.archetypes.rule.Operation.LESS_THAN;
import static net.liccioni.archetypes.rule.Operation.LESS_THAN_OR_EQUAL_TO;
import static net.liccioni.archetypes.rule.Operation.NOT_EQUAL_TO;

import java.util.Objects;

public class Variable<T extends Comparable<T>> extends RuleElement {
    private final T value;
    private final Class<?> type;

    public Variable(String name) {
        super(name);
        this.value = null;
        this.type = null;
    }

    public Variable(String name, T value) {
        super(name);
        this.value = value;
        this.type = value.getClass();
    }

    @Override
    public String getType() {
        return "Variable";
    }

    @Override
    void acceptStack(RuleExecutionStack stack) {
        stack.acceptElement(this);
    }

    public T getValue() {
        return value;
    }

    public Proposition equalTo(Variable<?> other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) == 0;
        return newProposition(newValue, other, EQUAL_TO.name());
    }

    public Proposition notEqualTo(Variable<?> other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) != 0;
        return newProposition(newValue, other, NOT_EQUAL_TO.name());
    }

    public Proposition greaterThan(Variable<?> other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) > 0;
        return newProposition(newValue, other, GREATER_THAN.name());
    }

    public Proposition lessThan(Variable<?> other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) < 0;
        return newProposition(newValue, other, LESS_THAN.name());
    }

    public Proposition greaterThanOrEqualTo(Variable<?> other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) >= 0;
        return newProposition(newValue, other, GREATER_THAN_OR_EQUAL_TO.name());
    }

    public Proposition lessThanOrEqualTo(Variable<?> other) {
        boolean newValue = isAssignableFrom(other) && other.compareTo(this.value) <= 0;
        return newProposition(newValue, other, LESS_THAN_OR_EQUAL_TO.name());
    }

    @SuppressWarnings("unchecked")
    private int compareTo(Object value) {
        return this.value.compareTo((T) value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Variable)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Variable<?> variable = (Variable<?>) o;
        return Objects.equals(getValue(), variable.getValue()) && getType().equals(variable.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getValue(), getType());
    }

    @Override
    public String toString() {
        return "Variable{" +
                "name=" + this.getName() + ", " +
                "value=" + value +
                ", type=" + type +
                '}';
    }

    protected boolean isAssignableFrom(Variable<?> other) {
        return other.type.isAssignableFrom(this.type);
    }

    protected Proposition newProposition(boolean newValue, Variable<?> other, String operation) {
        return new Proposition(String.format("%s_%s_%s", other.getName(), operation, this.getName()), newValue);
    }
}
