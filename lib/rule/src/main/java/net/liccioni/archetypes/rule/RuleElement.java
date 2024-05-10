package net.liccioni.archetypes.rule;


public interface RuleElement {

    String name();

    void acceptStack(RuleExecutionStack stack);
}
