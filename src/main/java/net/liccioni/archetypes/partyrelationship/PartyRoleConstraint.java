package net.liccioni.archetypes.partyrelationship;


import net.liccioni.archetypes.party.Party;

/**
 * @generated
 */
public class PartyRoleConstraint {

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
    public boolean canPlayRole(Party party) {
        //TODO
        return false;
    }
}
