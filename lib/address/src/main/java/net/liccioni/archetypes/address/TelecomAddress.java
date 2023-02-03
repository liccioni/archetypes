package net.liccioni.archetypes.address;

/**
 * @generated
 */
public class TelecomAddress extends Address {

    /**
     * @generated
     */
    private String countryCode;

    /**
     * @generated
     */
    private String nationalDirectDialingPrefix;

    /**
     * @generated
     */
    private String areaCode;

    /**
     * @generated
     */
    private String number;

    /**
     * @generated
     */
    private String extension;

    /**
     * @generated
     */
    private String physicalType;


    /**
     * @generated
     */
    private Locale locale;


    /**
     * @generated
     */
    public String getCountryCode() {
        return this.countryCode;
    }

    /**
     * @generated
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    /**
     * @generated
     */
    public String getNationalDirectDialingPrefix() {
        return this.nationalDirectDialingPrefix;
    }

    /**
     * @generated
     */
    public void setNationalDirectDialingPrefix(String nationalDirectDialingPrefix) {
        this.nationalDirectDialingPrefix = nationalDirectDialingPrefix;
    }


    /**
     * @generated
     */
    public String getAreaCode() {
        return this.areaCode;
    }

    /**
     * @generated
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }


    /**
     * @generated
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * @generated
     */
    public void setNumber(String number) {
        this.number = number;
    }


    /**
     * @generated
     */
    public String getExtension() {
        return this.extension;
    }

    /**
     * @generated
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }


    /**
     * @generated
     */
    public String getPhysicalType() {
        return this.physicalType;
    }

    /**
     * @generated
     */
    public void setPhysicalType(String physicalType) {
        this.physicalType = physicalType;
    }

    /**
     * @generated
     */
    public Locale getLocale() {
        return this.locale;
    }

    /**
     * @generated
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }


    @Override
    public String getAddress() {
        return this.number;
    }
}
