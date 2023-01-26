package net.liccioni.archetypes.rule;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RuleSet {

    private final List<Rule> rules;
    private final Map<String, RuleOverride> ruleOverrides = new HashMap<>();

    public RuleSet(List<Rule> rules) {
        this.rules = rules;
    }

    public RuleSet(Rule... rules) {
        this.rules = Arrays.asList(rules);
    }

    public boolean evaluate(RuleContext context) {
        return rules.stream()
                .filter(this::isNotOverride)
                .map(rule -> rule.evaluate(context))
                .allMatch(Proposition::getValue);
    }

    /**
     * @generated
     */
    public boolean addRule(Rule rule) {
        //TODO
        return false;
    }

    public void addRuleOverride(RuleOverride ruleOverride) {
        this.ruleOverrides.put(ruleOverride.getRuleName(), ruleOverride);
    }

    private boolean isNotOverride(final Rule rule) {
        return !Optional.ofNullable(ruleOverrides.get(rule.getName()))
                .map(RuleOverride::isOverride)
                .orElse(false);
    }
}
