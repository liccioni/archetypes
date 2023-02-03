package net.liccioni.archetypes.rule;


import java.util.function.Consumer;

public enum Operator implements RuleElement {

    NOT(RuleExecutionStack::not),
    AND(RuleExecutionStack::and),
    OR(RuleExecutionStack::or),
    XOR(RuleExecutionStack::xor),
    EQUAL_TO(RuleExecutionStack::equalTo),
    NOT_EQUAL_TO(RuleExecutionStack::notEqualTo),
    GREATER_THAN(RuleExecutionStack::greaterThan),
    LESS_THAN(RuleExecutionStack::lessThan),
    GREATER_THAN_OR_EQUAL_TO(RuleExecutionStack::greaterThanOrEqualTo),
    LESS_THAN_OR_EQUAL_TO(RuleExecutionStack::lessThanOrEqualTo),
    MATCHES(RuleExecutionStack::matches);

    private final Consumer<RuleExecutionStack> operation;

    Operator(final Consumer<RuleExecutionStack> operation) {
        this.operation = operation;
    }

    @Override
    public String getName() {
        return this.name();
    }

    @Override
    public void acceptStack(final RuleExecutionStack stack) {
        operation.accept(stack);
    }

    @Override
    public String toString() {
        return "Operator{name=" + this.name() + "} ";
    }
}
