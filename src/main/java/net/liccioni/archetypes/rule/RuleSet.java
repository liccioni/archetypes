package net.liccioni.archetypes.rule;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @generated
 */
public class RuleSet {

    private final List<Rule> rules;

    public RuleSet(List<Rule> rules) {
        this.rules = rules;
    }

    public RuleSet(Rule ... rules) {
        this.rules = Arrays.asList(rules);
    }

    public boolean evaluate(RuleContext context) {
        return rules.stream()
                .map(rule -> rule.evaluate(context))
                .allMatch(Proposition::getValue);
    }

    /**
     * @generated
     */
    private Set<RuleOverride> ruleOverrides;


    /**
     * @generated
     */
    public Set<RuleOverride> getRuleOverrides() {
        if (this.ruleOverrides == null) {
            this.ruleOverrides = new HashSet<RuleOverride>();
        }
        return this.ruleOverrides;
    }

    /**
     * @generated
     */
    public void setRuleOverrides(Set<RuleOverride> ruleOverrides) {
        this.ruleOverrides = ruleOverrides;
    }


    //                          Operations


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
