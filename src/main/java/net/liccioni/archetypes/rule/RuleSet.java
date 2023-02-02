package net.liccioni.archetypes.rule;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class RuleSet {

    private final Set<Rule> rules = new TreeSet<>(Comparator.comparing(Rule::getName));
    private final Map<String, RuleOverride> ruleOverrides = new HashMap<>();

    public RuleSet(List<Rule> rules) {

        this.rules.addAll(rules);
    }

    public RuleSet(Rule... rules) {
        this.rules.addAll(Arrays.asList(rules));
    }

    public boolean evaluate(RuleContext context) {
        return rules.stream()
                .filter(this::isNotOverride)
                .map(rule -> rule.evaluate(context))
                .allMatch(Proposition::getValue);
    }

    public void addRuleOverride(RuleOverride ruleOverride) {
        if (rules.stream().anyMatch(p -> p.getName().equals(ruleOverride.getRuleName()))) {
            this.ruleOverrides.put(ruleOverride.getRuleName(), ruleOverride);
        }
    }

    private boolean isNotOverride(final Rule rule) {
        return !Optional.ofNullable(ruleOverrides.get(rule.getName()))
                .map(RuleOverride::isOverride)
                .orElse(false);
    }

    @Override
    public String toString() {
        return "RuleSet{" +
                "rules=\n" + rules.stream().map(Object::toString).collect(Collectors.joining(",\n")) +
                ",\n ruleOverrides=" +
                ruleOverrides.values().stream().map(Object::toString).collect(Collectors.joining(",")) +
                '}';
    }
}
