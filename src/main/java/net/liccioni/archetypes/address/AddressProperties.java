package net.liccioni.archetypes.address;
import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class AddressProperties {
    
    /**
    * @generated
    */
    private TimeDate validFrom;
    
    /**
    * @generated
    */
    private TimeDate validTo;
    
    /**
    * @generated
    */
    private Set<String> use;
    
    
    /**
    * @generated
    */
    private Address address;
    
    

    /**
    * @generated
    */
    public TimeDate getValidFrom() {
        return this.validFrom;
    }
    
    /**
    * @generated
    */
    public TimeDate setValidFrom(TimeDate validFrom) {
        this.validFrom = validFrom;
    }
    
    
    /**
    * @generated
    */
    public TimeDate getValidTo() {
        return this.validTo;
    }
    
    /**
    * @generated
    */
    public TimeDate setValidTo(TimeDate validTo) {
        this.validTo = validTo;
    }
    
    
    /**
    * @generated
    */
    public Set<String> getUse() {
        if (this.use == null) {
            this.use = new HashSet<String>();
        }
        return this.use;
    }
    
    /**
    * @generated
    */
    public Set<String> setUse(String use) {
        this.use = use;
    }

    /**
    * @generated
    */
    public Address getAddress() {
        return this.address;
    }
    
    /**
    * @generated
    */
    public Address setAddress(Address address) {
        this.address = address;
    }
    
    
    
}
