package net.liccioni.archetypes.rule;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.BiFunction;

class RuleExecutionStack {

    private final Deque<RuleElement> stack = new ArrayDeque<>();

    private final RuleContext ruleContext;

    RuleExecutionStack(RuleContext ruleContext) {
        this.ruleContext = ruleContext;
    }

    Proposition result() {
        if (stack.isEmpty()) {
            return null;
        }
        return (Proposition) stack.pop();
    }

    void and() {
        performProposition(Proposition::and);
    }

    void or() {
        performProposition(Proposition::or);
    }

    void xor() {
        performProposition(Proposition::xor);
    }

    void not() {
        Proposition rhs = (Proposition) stack.pop();
        stack.push(rhs.not());
    }

    void equalTo() {
        performVariable(Variable::equalTo);
    }

    void notEqualTo() {
        performVariable(Variable::notEqualTo);
    }

    void greaterThan() {
        performVariable(Variable::greaterThan);
    }

    void lessThan() {
        performVariable(Variable::lessThan);
    }

    void greaterThanOrEqualTo() {
        performVariable(Variable::greaterThanOrEqualTo);
    }

    void lessThanOrEqualTo() {
        performVariable(Variable::lessThanOrEqualTo);
    }

    void acceptElement(RuleElement element) {
        element.acceptStack(this);
    }

    void acceptElement(Proposition proposition) {
        findInContextAndStack(proposition);
    }

    void acceptElement(Variable variable) {
        findInContextAndStack(variable);
    }

    private void performProposition(BiFunction<Proposition, Proposition, Proposition> operation) {
        Proposition lhs = (Proposition) stack.pop();
        Proposition rhs = (Proposition) stack.pop();
        stack.push(operation.apply(lhs, rhs));
    }

    private void performVariable(BiFunction<Variable, Variable, Proposition> operation) {
        Variable lhs = (Variable) stack.pop();
        Variable rhs = (Variable) stack.pop();
        stack.push(operation.apply(lhs, rhs));
    }

    private void findInContextAndStack(RuleElement element) {
        String name = element.name();
        RuleElement fromContext = ruleContext.findElement(name)
                .orElseThrow(() -> new IllegalArgumentException("Rule Element {" + name + "} not provided in context"));
        stack.push(fromContext);
    }
}
