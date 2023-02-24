package net.liccioni.archetypes.rule;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class RuleSet {

    String name;
    @Getter(AccessLevel.NONE)
    Set<Rule> rules = new TreeSet<>(Comparator.comparing(Rule::getName));
    @Getter(AccessLevel.NONE)
    Map<String, RuleOverride> ruleOverrides = new HashMap<>();

    @Builder
    public RuleSet(final String name, Rule... rules) {
        this.name = name;
        this.rules.addAll(Arrays.asList(rules));
    }

    public boolean evaluate(RuleContext context) {
        return rules.stream()
                .filter(this::isNotOverride)
                .map(rule -> rule.evaluate(context))
                .allMatch(Proposition::isValue);
    }

    public void addRuleOverride(RuleOverride ruleOverride) {
        if (rules.stream().anyMatch(p -> p.getName().equals(ruleOverride.getRuleName()))) {
            this.ruleOverrides.put(ruleOverride.getRuleName(), ruleOverride);
        }
    }

    private boolean isNotOverride(final Rule rule) {
        return !Optional.ofNullable(ruleOverrides.get(rule.getName()))
                .map(RuleOverride::getOverride)
                .orElse(false);
    }
}
