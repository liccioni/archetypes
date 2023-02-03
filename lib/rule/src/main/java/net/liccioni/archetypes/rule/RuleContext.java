package net.liccioni.archetypes.rule;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

@Value
public class RuleContext {

    String name;

    @Getter(AccessLevel.NONE)
    Map<String, RuleElement> elements = new HashMap<>();

    public RuleContext addProposition(String statement, boolean value) {
        Proposition proposition = new Proposition(statement, value);
        elements.put(statement, proposition);
        return this;
    }

    public <R> RuleContext addVariable(String name, R value) {
        elements.put(name, new Variable<>(name, value));
        return this;
    }

    public RuleContext addVariable(String name, String value) {
        elements.put(name, new StringVariable(name, value));
        return this;
    }

    public Optional<RuleElement> findElement(String name) {
        return Optional.ofNullable(elements.get(name));
    }

    public void append(RuleContext context) {
        this.elements.putAll(context.elements);
    }
}
