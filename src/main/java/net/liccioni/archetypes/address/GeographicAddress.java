package net.liccioni.archetypes.address;

import java.util.HashSet;
import java.util.Set;

/**
 * @generated
 */
public class GeographicAddress extends Address {

    /**
     * @generated
     */
    private Set<String> addressLine;

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
    public Set<String> getAddressLine() {
        if (this.addressLine == null) {
            this.addressLine = new HashSet<String>();
        }
        return this.addressLine;
    }

    /**
     * @generated
     */
    public void setAddressLine(Set<String> addressLine) {
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
    public void setCity(String city) {
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
    public void setRegionOrState(String regionOrState) {
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
    public void setZipOrPostCode(String zipOrPostCode) {
        this.zipOrPostCode = zipOrPostCode;
    }


    @Override
    public String getAddress() {
        return String.join(",", this.addressLine);
    }
}
