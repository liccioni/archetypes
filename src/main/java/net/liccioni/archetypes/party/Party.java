package net.liccioni.archetypes.party;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public abstract class Party {
    
    /**
    * @generated
    */
    private String name;
    
    
    /**
    * @generated
    */
    private Set<RegisteredIdentifier> registeredIdentifier;
    
    /**
    * @generated
    */
    private PartyIdentifier partyIdentifier;
    
    

    /**
    * @generated
    */
    private String getName() {
        return this.name;
    }
    
    /**
    * @generated
    */
    private void setName(String name) {
        this.name = name;
    }
    
    
    
    /**
    * @generated
    */
    public PartyIdentifier getPartyIdentifier() {
        return this.partyIdentifier;
    }
    
    /**
    * @generated
    */
    public void setPartyIdentifier(PartyIdentifier partyIdentifier) {
        this.partyIdentifier = partyIdentifier;
    }
    
    
    /**
    * @generated
    */
    public Set<RegisteredIdentifier> getRegisteredIdentifier() {
        if (this.registeredIdentifier == null) {
            this.registeredIdentifier = new HashSet<RegisteredIdentifier>();
        }
        return this.registeredIdentifier;
    }

    /**
    * @generated
    */
    public void setRegisteredIdentifier(RegisteredIdentifier registeredIdentifier) {
        this.registeredIdentifier = registeredIdentifier;
    }
    
}
