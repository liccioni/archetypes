package net.liccioni.archetypes.rule;

import java.util.HashSet;
import java.util.Set;

/**
 * @generated
 */
public class Rule {

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
    public boolean addOperator(Operator operator) {
        //TODO
        return false;
    }


    /**
     * @generated
     */
    public boolean addProposition(Proposition operator) {
        //TODO
        return false;
    }


    /**
     * @generated
     */
    public boolean addVariable(Variable variable) {
        //TODO
        return false;
    }


    /**
     * @generated
     */
    public Proposition evaluate(RuleContext context) {
        //TODO
        return null;
    }
}
