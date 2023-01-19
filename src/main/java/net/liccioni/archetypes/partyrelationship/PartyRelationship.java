package net.liccioni.archetypes.partyrelationship;


/**
* @generated
*/
public class PartyRelationship {
    
    /**
    * @generated
    */
    private PartyRole supplier;
    
    /**
    * @generated
    */
    private PartyRole client;
    
    

    /**
    * @generated
    */
    private PartyRelationshipType type;



    /**
    * @generated
    */
    public PartyRelationshipType getType() {
        return this.type;
    }

    /**
    * @generated
    */
    public void setType(PartyRelationshipType type) {
        this.type = type;
    }

    /**
    * @generated
    */
    public String getName() {
        //TODO
        return "";
    }
    
    /**
    * @generated
    */
    public String getDescription() {
        //TODO
        return "";
    }
    
    /**
    * @generated
    */
    public PartyRole getSupplier() {
        return this.supplier;
    }
    
    /**
    * @generated
    */
    public void setSupplier(PartyRole supplier) {
        this.supplier = supplier;
    }
    
    
    /**
    * @generated
    */
    public PartyRole getClient() {
        return this.client;
    }
    
    /**
    * @generated
    */
    public void setClient(PartyRole client) {
        this.client = client;
    }
    
    
    
}
