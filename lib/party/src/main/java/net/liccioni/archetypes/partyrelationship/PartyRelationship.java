package net.liccioni.archetypes.partyrelationship;


/**
 * @generated
 */
public class PartyRelationship {


    /**
     * @generated
     */
    private net.liccioni.archetypes.partyrelationship.PartyRole supplier;

    /**
     * @generated
     */
    private net.liccioni.archetypes.partyrelationship.PartyRole client;

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
    public net.liccioni.archetypes.partyrelationship.PartyRole getSupplier() {
        return this.supplier;
    }

    /**
     * @generated
     */
    public void setSupplier(net.liccioni.archetypes.partyrelationship.PartyRole supplier) {
        this.supplier = supplier;
    }


    /**
     * @generated
     */
    public net.liccioni.archetypes.partyrelationship.PartyRole getClient() {
        return this.client;
    }

    /**
     * @generated
     */
    public void setClient(PartyRole client) {
        this.client = client;
    }


    //                          Operations


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
}
