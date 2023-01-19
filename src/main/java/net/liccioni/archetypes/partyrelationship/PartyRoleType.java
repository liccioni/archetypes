package net.liccioni.archetypes.partyrelationship;

import java.util.Set;
import java.util.HashSet;

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
    private Set<Responsability> mandatoryResponsibilities;

    /**
    * @generated
    */
    private Set<AssignedResponsability> assignedResponsibilities;

    /**
    * @generated
    */
    private PartyRoleConstraint constraints;
    
    /**
    * @generated
    */
    private Set<Responsability> optionalResponsibilities;

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
    public Set<Responsability> getOptionalResponsibilities() {
        if (this.optionalResponsibilities == null) {
            this.optionalResponsibilities = new HashSet<Responsability>();
        }
        return this.optionalResponsibilities;
    }

    /**
    * @generated
    */
    public void setOptionalResponsibilities(Set<Responsability> optionalResponsibilities) {
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
    
    
    /**
    * @generated
    */
    public Set<Responsability> getMandatoryResponsibilities() {
        if (this.mandatoryResponsibilities == null) {
            this.mandatoryResponsibilities = new HashSet<Responsability>();
        }
        return this.mandatoryResponsibilities;
    }

    /**
    * @generated
    */
    public void setMandatoryResponsibilities(Set<Responsability> mandatoryResponsibilities) {
        this.mandatoryResponsibilities = mandatoryResponsibilities;
    }

    /**
    * @generated
    */
    public Set<AssignedResponsability> getAssignedResponsibilities() {
        if (this.assignedResponsibilities == null) {
            this.assignedResponsibilities = new HashSet<AssignedResponsability>();
        }
        return this.assignedResponsibilities;
    }

    /**
    * @generated
    */
    public void setAssignedResponsibilities(Set<AssignedResponsability> assignedResponsibilities) {
        this.assignedResponsibilities = assignedResponsibilities;
    }

    //                          Operations                                  
    
    
    
    /**
    * @generated
    */
    public boolean canPlayRole(Party party)
    {
        //TODO
        return false;
    }
    
    
    
    /**
    * @generated
    */
    public boolean canPlayRole(Party party, RuleContext context)
    {
        //TODO
        return false;
    }
    
    
}
