package net.liccioni.archetypes.partyrelationship;

import java.util.HashSet;
import java.util.Set;
import net.liccioni.archetypes.party.Party;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleSet;

/**
 * @generated
 */
public class PartyRoleType {

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
    private RuleSet requirementsForRole;

    /**
     * @generated
     */
    private Set<AssignedResponsibility> assignedResponsibilities;

    /**
     * @generated
     */
    private PartyRoleConstraint constraints;

    /**
     * @generated
     */
    private Set<net.liccioni.archetypes.partyrelationship.Responsibility> optionalResponsibilities;

    /**
     * @generated
     */
    private Set<net.liccioni.archetypes.partyrelationship.Responsibility> mandatoryResponsibilities;


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
    public RuleSet getRequirementsForRole() {
        return this.requirementsForRole;
    }

    /**
     * @generated
     */
    public void setRequirementsForRole(RuleSet requirementsForRole) {
        this.requirementsForRole = requirementsForRole;
    }


    /**
     * @generated
     */
    public Set<AssignedResponsibility> getAssignedResponsibilities() {
        if (this.assignedResponsibilities == null) {
            this.assignedResponsibilities = new HashSet<AssignedResponsibility>();
        }
        return this.assignedResponsibilities;
    }

    /**
     * @generated
     */
    public void setAssignedResponsibilities(Set<AssignedResponsibility> assignedResponsibilities) {
        this.assignedResponsibilities = assignedResponsibilities;
    }


    /**
     * @generated
     */
    public Set<net.liccioni.archetypes.partyrelationship.Responsibility> getMandatoryResponsibilities() {
        if (this.mandatoryResponsibilities == null) {
            this.mandatoryResponsibilities = new HashSet<net.liccioni.archetypes.partyrelationship.Responsibility>();
        }
        return this.mandatoryResponsibilities;
    }

    /**
     * @generated
     */
    public void setMandatoryResponsibilities(Set<net.liccioni.archetypes.partyrelationship.Responsibility> mandatoryResponsibilities) {
        this.mandatoryResponsibilities = mandatoryResponsibilities;
    }


    /**
     * @generated
     */
    public Set<net.liccioni.archetypes.partyrelationship.Responsibility> getOptionalResponsibilities() {
        if (this.optionalResponsibilities == null) {
            this.optionalResponsibilities = new HashSet<net.liccioni.archetypes.partyrelationship.Responsibility>();
        }
        return this.optionalResponsibilities;
    }

    /**
     * @generated
     */
    public void setOptionalResponsibilities(Set<Responsibility> optionalResponsibilities) {
        this.optionalResponsibilities = optionalResponsibilities;
    }


    /**
     * @generated
     */
    public PartyRoleConstraint getConstraints() {
        return this.constraints;
    }

    /**
     * @generated
     */
    public void setConstraints(PartyRoleConstraint constraints) {
        this.constraints = constraints;
    }


    //                          Operations


    /**
     * @generated
     */
    public boolean canPlayRole(Party party) {
        //TODO
        return false;
    }


    /**
     * @generated
     */
    public boolean canPlayRole(Party party, RuleContext context) {
        //TODO
        return false;
    }
}
