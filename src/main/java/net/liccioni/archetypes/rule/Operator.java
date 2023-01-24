package net.liccioni.archetypes.rule;


import java.util.function.Consumer;

/**
 * @generated
 */
public class Operator extends RuleElement {

    private final Consumer<RuleExecutionStack> operation;

    public Operator(final String name,
                    final Consumer<RuleExecutionStack> operation) {
        super(name);
        this.operation = operation;
    }

    @Override
    public String getType() {
        return "Operator";
    }

    @Override
    void acceptStack(final RuleExecutionStack ruleExecutionStack) {
        operation.accept(ruleExecutionStack);
    }
}
