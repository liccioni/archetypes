package net.liccioni.archetypes.rule;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RuleContext {

    private final Map<String, RuleElement> elements = new HashMap<>();

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


    /**
     * @generated
     */
    private String name;


    /**
     * @generated
     */
    public String getName() {
        return this.name;
    }

    /**
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }

    //                          Operations


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
