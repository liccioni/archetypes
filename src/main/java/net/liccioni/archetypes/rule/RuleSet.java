package net.liccioni.archetypes.rule;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class RuleSet {
    
    
    /**
    * @generated
    */
    private Set<Rule> rules;
    
    /**
    * @generated
    */
    private Set<RuleOverride> ruleOverrides;
    
    

    
    /**
    * @generated
    */
    public Set<Rule> getRules() {
        if (this.rules == null) {
            this.rules = new HashSet<Rule>();
        }
        return this.rules;
    }
    
    /**
    * @generated
    */
    public void setRules(Set<Rule> rules) {
        this.rules = rules;
    }
    
    
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
    public boolean addRule(Rule rule)
    {
        //TODO
        return false;
    }
    
    
    
    /**
    * @generated
    */
    public boolean addRuleOverride(RuleOverride ruleOverride)
    {
        //TODO
        return false;
    }
    
    
    
    /**
    * @generated
    */
    public Proposition evaluate(RuleContext context)
    {
        //TODO
        return null;
    }
    
    
}
