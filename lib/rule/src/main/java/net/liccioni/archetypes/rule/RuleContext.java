package net.liccioni.archetypes.rule;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public record RuleContext(String name, Map<String, RuleElement> elements) {

    @Builder(toBuilder = true)
    public RuleContext(String name, Map<String, RuleElement> elements) {
        this.name = name;
        this.elements = Optional.ofNullable(elements).orElseGet(HashMap::new);
    }

    public RuleContext addProposition(String statement, boolean value) {
        Proposition proposition = new Proposition(statement, value);
        elements.put(statement, proposition);
        return this;
    }

    public <R> RuleContext addVariable(String name, Comparable<R> value) {
        elements.put(name, new Variable(name, value));
        return this;
    }

//    public RuleContext addVariable(String name, String value) {
//        elements.put(name, new StringVariable(name, value));
//        return this;
//    }

    public Optional<RuleElement> findElement(String name) {
        return Optional.ofNullable(elements.get(name));
    }

    public void append(RuleContext context) {
        this.elements.putAll(context.elements);
    }
}
