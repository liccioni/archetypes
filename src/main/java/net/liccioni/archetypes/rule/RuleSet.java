package net.liccioni.archetypes.rule;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @generated
 */
public class RuleSet {

    private final List<Rule> rules;
    private Set<RuleOverride> ruleOverrides;

    public RuleSet(List<Rule> rules) {
        this.rules = rules;
    }

    public RuleSet(Rule... rules) {
        this.rules = Arrays.asList(rules);
    }

    public boolean evaluate(RuleContext context) {
        return rules.stream()
                .map(rule -> rule.evaluate(context))
                .allMatch(Proposition::getValue);
    }

    public void setRuleOverrides(Set<RuleOverride> ruleOverrides) {
        this.ruleOverrides = ruleOverrides;
    }


    /**
     * @generated
     */
    public boolean addRule(Rule rule) {
        //TODO
        return false;
    }


    /**
     * @generated
     */
    public boolean addRuleOverride(RuleOverride ruleOverride) {
        //TODO
        return false;
    }
}
