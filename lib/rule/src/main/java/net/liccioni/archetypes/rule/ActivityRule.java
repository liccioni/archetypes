package net.liccioni.archetypes.rule;


import java.util.List;

public abstract class ActivityRule extends Rule {
    public ActivityRule(final String name, final List<RuleElement> elements) {
        super(name, elements);
    }

    public abstract boolean activity();
}
