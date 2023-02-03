package net.liccioni.archetypes.rule;


public interface RuleElement {

    String getName();

    void acceptStack(RuleExecutionStack stack);
}
