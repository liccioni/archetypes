package net.liccioni.archetypes.party;

import java.util.Set;
import java.util.HashSet;
import net.liccioni.archetypes.address.AddressProperties;
import net.liccioni.archetypes.preference.Preference;

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
    private Capabilities capabilities;


    /**
    * @generated
    */
    private Set<Preference> preferences;


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
    private Set<PartyRole> roles;


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
    public Set<PartyRole> getRoles() {
        if (this.roles == null) {
            this.roles = new HashSet<PartyRole>();
        }
        return this.roles;
    }

    /**
    * @generated
    */
    public void setRoles(Set<PartyRole> roles) {
        this.roles = roles;
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
    public Set<Preference> getPreferences() {
        if (this.preferences == null) {
            this.preferences = new HashSet<Preference>();
        }
        return this.preferences;
    }

    /**
    * @generated
    */
    public void setPreferences(Set<Preference> preferences) {
        this.preferences = preferences;
    }

    /**
    * @generated
    */
    public Capabilities getCapabilities() {
        return this.capabilities;
    }

    /**
    * @generated
    */
    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
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
