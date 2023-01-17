package net.liccioni.archetypes.party;

import java.util.Set;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.OrderedSet;

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
    private OrderedSet<AddressProperties> addressProperties;


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
    public String setName(String name) {
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
    public PartyIdentifier setPartyIdentifier(PartyIdentifier partyIdentifier) {
        this.partyIdentifier = partyIdentifier;
    }
    
    
    /**
    * @generated
    */
    public OrderedSet<AddressProperties> getAddressProperties() {
        if (this.addressProperties == null) {
            this.addressProperties = new OrderedSet<AddressProperties>();
        }
        return this.addressProperties;
    }

    /**
    * @generated
    */
    public OrderedSet<AddressProperties> setAddressProperties(AddressProperties addressProperties) {
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
    public Set<RegisteredIdentifier> setRegisteredIdentifier(RegisteredIdentifier registeredIdentifier) {
        this.registeredIdentifier = registeredIdentifier;
    }
}
