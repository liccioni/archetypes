package net.liccioni.archetypes.partyrelationship;


/**
 * @generated
 */
public class PartyRelationshipConstraint {

    /**
     * @generated
     */
    private String typeOfParty;


    /**
     * @generated
     */
    public String getTypeOfParty() {
        return this.typeOfParty;
    }

    /**
     * @generated
     */
    public void setTypeOfParty(String typeOfParty) {
        this.typeOfParty = typeOfParty;
    }


    //                          Operations


    /**
     * @generated
     */
    public boolean canFormRelationship(net.liccioni.archetypes.partyrelationship.PartyRole client, PartyRole supplier) {
        //TODO
        return false;
    }
}
