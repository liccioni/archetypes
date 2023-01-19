package net.liccioni.archetypes.partyrelationship;


/**
* @generated
*/
public class PartyRelationshipType {
    
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
    private RuleSet requirementsForRelationship;
    
    /**
    * @generated
    */
    private PartyRelationshipConstraint constraints;
    
    

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
    public PartyRelationshipConstraint getConstraints() {
        return this.constraints;
    }
    
    /**
    * @generated
    */
    public void setConstraints(PartyRelationshipConstraint constraints) {
        this.constraints = constraints;
    }
    
    
    /**
    * @generated
    */
    public RuleSet getRequirementsForRelationship() {
        return this.requirementsForRelationship;
    }
    
    /**
    * @generated
    */
    public void setRequirementsForRelationship(RuleSet requirementsForRelationship) {
        this.requirementsForRelationship = requirementsForRelationship;
    }
    
    
    

    //                          Operations                                  
    
    
    
    /**
    * @generated
    */
    public boolean canFormRelationship(PartyRole client, PartyRole supplier)
    {
        //TODO
        return false;
    }
    
    
    
    /**
    * @generated
    */
    public boolean canFormRelationship(PartyRole client, PartyRole supplier, RuleContext context)
    {
        //TODO
        return false;
    }
    
    
}
