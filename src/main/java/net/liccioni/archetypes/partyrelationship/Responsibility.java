package net.liccioni.archetypes.partyrelationship;


import net.liccioni.archetypes.rule.RuleSet;

/**
 * @generated
 */
public class Responsibility {

    /**
     * @generated
     */
    private String name;

    /**
     * @generated
     */
    private String description;


    /**
     * @generated
     */
    private RuleSet conditionsOfSatisfaction;

    /**
     * @generated
     */
    private RuleSet requirementsForResponsability;


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
    public String getDescription() {
        return this.description;
    }

    /**
     * @generated
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * @generated
     */
    public RuleSet getRequirementsForResponsability() {
        return this.requirementsForResponsability;
    }

    /**
     * @generated
     */
    public void setRequirementsForResponsability(RuleSet requirementsForResponsability) {
        this.requirementsForResponsability = requirementsForResponsability;
    }


    /**
     * @generated
     */
    public RuleSet getConditionsOfSatisfaction() {
        return this.conditionsOfSatisfaction;
    }

    /**
     * @generated
     */
    public void setConditionsOfSatisfaction(RuleSet conditionsOfSatisfaction) {
        this.conditionsOfSatisfaction = conditionsOfSatisfaction;
    }
}
