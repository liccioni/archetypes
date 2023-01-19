package net.liccioni.archetypes.rule;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class RuleContext {
    
    /**
    * @generated
    */
    private String name;
    
    
    /**
    * @generated
    */
    private Set<RuleElement> elements;
    
    

    /**
    * @generated
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * @generated
    */
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    /**
    * @generated
    */
    public Set<RuleElement> getElements() {
        if (this.elements == null) {
            this.elements = new HashSet<RuleElement>();
        }
        return this.elements;
    }
    
    /**
    * @generated
    */
    public void setElements(Set<RuleElement> elements) {
        this.elements = elements;
    }
    
    
    

    //                          Operations                                  
    
    
    
    /**
    * @generated
    */
    public boolean addProposition(String name, boolean value)
    {
        //TODO
        return false;
    }
    
    
    
    /**
    * @generated
    */
    public boolean addVariable(String name, String value)
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
    public boolean append(RuleContext context)
    {
        //TODO
        return false;
    }
    
    
}
