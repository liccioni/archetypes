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
    private Set<AssignedResponsability> assignedResponsabilities;
    
    /**
    * @generated
    */
    private PartyRoleConstraint constraints;
    
    /**
    * @generated
    */
    private Set<Responsability> mandatiryResponsabilities;
    
    /**
    * @generated
    */
    private Set<Responsability> optionalResponsabilities;
    
    /**
    * @generated
    */
    private RuleSet requierementsForRole;
    
    

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
    public Set<Responsability> getMandatiryResponsabilities() {
        if (this.mandatiryResponsabilities == null) {
            this.mandatiryResponsabilities = new HashSet<Responsability>();
        }
        return this.mandatiryResponsabilities;
    }
    
    /**
    * @generated
    */
    public void setMandatiryResponsabilities(Set<Responsability> mandatiryResponsabilities) {
        this.mandatiryResponsabilities = mandatiryResponsabilities;
    }
    
    
    /**
    * @generated
    */
    public Set<Responsability> getOptionalResponsabilities() {
        if (this.optionalResponsabilities == null) {
            this.optionalResponsabilities = new HashSet<Responsability>();
        }
        return this.optionalResponsabilities;
    }
    
    /**
    * @generated
    */
    public void setOptionalResponsabilities(Set<Responsability> optionalResponsabilities) {
        this.optionalResponsabilities = optionalResponsabilities;
    }
    
    
    /**
    * @generated
    */
    public Set<AssignedResponsability> getAssignedResponsabilities() {
        if (this.assignedResponsabilities == null) {
            this.assignedResponsabilities = new HashSet<AssignedResponsability>();
        }
        return this.assignedResponsabilities;
    }
    
    /**
    * @generated
    */
    public void setAssignedResponsabilities(Set<AssignedResponsability> assignedResponsabilities) {
        this.assignedResponsabilities = assignedResponsabilities;
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
    public RuleSet getRequierementsForRole() {
        return this.requierementsForRole;
    }
    
    /**
    * @generated
    */
    public void setRequierementsForRole(RuleSet requierementsForRole) {
        this.requierementsForRole = requierementsForRole;
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
