package net.liccioni.archetypes.rule;

import lombok.Builder;

import java.util.*;

public record RuleSet(String name, Set<Rule> rules, Map<String, RuleOverride> ruleOverrides) {

    @Builder(toBuilder = true)
    public RuleSet(String name, Set<Rule> rules, Map<String, RuleOverride> ruleOverrides) {
        this.name = name;
        this.rules = new TreeSet<>(Comparator.comparing(Rule::name));
        this.ruleOverrides = Optional.ofNullable(ruleOverrides).orElseGet(HashMap::new);
        Optional.ofNullable(rules).ifPresent(this.rules::addAll);
    }

    public RuleSet(final String name, Rule... rules) {
        this(name, new HashSet<>(Arrays.asList(rules)), new HashMap<>());
    }

    public boolean evaluate(RuleContext context) {
        return rules.stream()
                .filter(this::isNotOverride)
                .map(rule -> rule.evaluate(context))
                .allMatch(Proposition::value);
    }

    public void addRuleOverride(RuleOverride ruleOverride) {
        if (rules.stream().anyMatch(p -> p.name().equals(ruleOverride.ruleName()))) {
            this.ruleOverrides.put(ruleOverride.ruleName(), ruleOverride);
        }
    }

    private boolean isNotOverride(final Rule rule) {
        return !Optional.ofNullable(ruleOverrides.get(rule.name()))
                .map(RuleOverride::override)
                .orElse(false);
    }
}
