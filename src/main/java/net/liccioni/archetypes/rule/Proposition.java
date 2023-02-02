package net.liccioni.archetypes.rule;


import static net.liccioni.archetypes.rule.Operator.AND;
import static net.liccioni.archetypes.rule.Operator.NOT;
import static net.liccioni.archetypes.rule.Operator.OR;
import static net.liccioni.archetypes.rule.Operator.XOR;

import java.util.Objects;

public class Proposition implements RuleElement {

    private final String name;
    private final boolean value;

    public Proposition(String name) {
        this.name = name;
        this.value = false;
    }

    public Proposition(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String getName() {
        return this.name;
    }

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Proposition)) {
            return false;
        }
        Proposition that = (Proposition) o;
        return value == that.value && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "Proposition{" +
                "name=" + this.getName() + ", " +
                "value=" + value +
                '}';
    }
}
