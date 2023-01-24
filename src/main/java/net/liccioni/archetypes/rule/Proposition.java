package net.liccioni.archetypes.rule;


import static net.liccioni.archetypes.rule.Operation.AND;
import static net.liccioni.archetypes.rule.Operation.NOT;
import static net.liccioni.archetypes.rule.Operation.OR;
import static net.liccioni.archetypes.rule.Operation.XOR;

import java.util.Objects;

/**
 * @generated
 */
public class Proposition extends RuleElement {

    private final boolean value;

    public Proposition(String name) {
        super(name);
        this.value = false;
    }

    public Proposition(String name, boolean value) {
        super(name);
        this.value = value;
    }

    @Override
    public String getType() {
        return "Proposition";
    }

    @Override
    void acceptStack(RuleExecutionStack stack) {
        stack.acceptElement(this);
    }

    public boolean getValue() {
        return value;
    }

    public Proposition and(Proposition other) {
        return newProposition(other.getName(), AND.name(), other.value && this.value);
    }

    public Proposition or(Proposition other) {
        return newProposition(other.getName(), OR.name(), other.value || this.value);
    }

    public Proposition xor(Proposition other) {
        return newProposition(other.getName(), XOR.name(), other.value ^ this.value);
    }

    public Proposition not() {
        return new Proposition(String.format("%s_%s", NOT.name(), this.getName()), !this.value);
    }

    private Proposition newProposition(String otherName, String operation, boolean newValue) {
        return new Proposition(String.format("%s_%s_%s", otherName, operation, this.getName()), newValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Proposition)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Proposition that = (Proposition) o;
        return getValue() == that.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getValue());
    }

    @Override
    public String toString() {
        return "Proposition{" +
                "name=" + this.getName() + ", " +
                "value=" + value +
                '}';
    }
}
