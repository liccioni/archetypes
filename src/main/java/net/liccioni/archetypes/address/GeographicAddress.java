package net.liccioni.archetypes.address;
import java.util.SortedSet;
import java.util.OrderedSet;

/**
* @generated
*/
public class GeographicAddress extends Address {
    
    /**
    * @generated
    */
    private OrderedSet<String> addressLine;
    
    /**
    * @generated
    */
    private String city;
    
    /**
    * @generated
    */
    private String regionOrState;
    
    /**
    * @generated
    */
    private String zipOrPostCode;
    
    
    

    /**
    * @generated
    */
    public OrderedSet<String> getAddressLine() {
        if (this.addressLine == null) {
            this.addressLine = new OrderedSet<String>();
        }
        return this.addressLine;
    }
    
    /**
    * @generated
    */
    public OrderedSet<String> setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    /**
    * @generated
    */
    public String getCity() {
        return this.city;
    }
    
    /**
    * @generated
    */
    public String setCity(String city) {
        this.city = city;
    }
    
    
    /**
    * @generated
    */
    public String getRegionOrState() {
        return this.regionOrState;
    }
    
    /**
    * @generated
    */
    public String setRegionOrState(String regionOrState) {
        this.regionOrState = regionOrState;
    }
    
    
    /**
    * @generated
    */
    public String getZipOrPostCode() {
        return this.zipOrPostCode;
    }
    
    /**
    * @generated
    */
    public String setZipOrPostCode(String zipOrPostCode) {
        this.zipOrPostCode = zipOrPostCode;
    }
    
    
    
    
}
