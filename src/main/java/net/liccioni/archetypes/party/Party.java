package net.liccioni.archetypes.party;

import java.util.Set;
import java.util.HashSet;
import net.liccioni.archetypes.address.AddressProperties;

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
    private Set<AddressProperties> addressProperties;


    /**
    * @generated
    */
    private PartyIdentifier partyIdentifier;
    
    

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
    public Set<AddressProperties> getAddressProperties() {
        if (this.addressProperties == null) {
            this.addressProperties = new HashSet<AddressProperties>();
        }
        return this.addressProperties;
    }

    /**
    * @generated
    */
    public void setAddressProperties(Set<AddressProperties> addressProperties) {
        this.addressProperties = addressProperties;
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
    public void setRegisteredIdentifier(Set<RegisteredIdentifier> registeredIdentifier) {
        this.registeredIdentifier = registeredIdentifier;
    }
}
