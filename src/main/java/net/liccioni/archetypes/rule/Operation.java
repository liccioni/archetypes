package net.liccioni.archetypes.rule;

import java.util.List;
import java.util.function.Consumer;

public enum Operation {

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

    private final Operator operator;

    Operation(final Consumer<RuleExecutionStack> operation) {
        this.operator = new Operator(this.name(), operation);
    }

    public Operator getOperator() {
        return this.operator;
    }
}
