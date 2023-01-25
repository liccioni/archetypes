package net.liccioni.archetypes.rule;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RuleContext {

    private final String name;

    private final Map<String, RuleElement> elements = new HashMap<>();

    public RuleContext(final String name) {
        this.name = name;
    }

    public void addProposition(String statement, boolean value) {
        Proposition proposition = new Proposition(statement, value);
        elements.put(statement, proposition);
    }

    public <R extends Comparable<R>> void addVariable(String name, R value) {
        elements.put(name, new Variable<>(name, value));
    }

    public void addVariable(String name, String value) {
        elements.put(name, new StringVariable(name, value));
    }

    public Optional<RuleElement> findElement(String name) {
        return Optional.ofNullable(elements.get(name));
    }

    public String getName() {
        return this.name;
    }

    /**
     * @generated
     */
    public boolean addRuleOverride(RuleOverride ruleOverride) {
        //TODO
        return false;
    }


    /**
     * @generated
     */
    public boolean append(RuleContext context) {
        //TODO
        return false;
    }
}
