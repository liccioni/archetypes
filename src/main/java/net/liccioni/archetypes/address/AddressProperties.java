package net.liccioni.archetypes.address;
import java.util.Set;
import java.util.HashSet;
import net.liccioni.archetypes.TimeDate;

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
    public void setValidFrom(TimeDate validFrom) {
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
    public void setValidTo(TimeDate validTo) {
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
    public void setUse(Set<String> use) {
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
    public void setAddress(Address address) {
        this.address = address;
    }
    
    
    
}
