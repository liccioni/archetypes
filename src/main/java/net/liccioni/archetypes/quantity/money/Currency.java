package net.liccioni.archetypes.quantity.money;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class Currency extends Metric {
    
    /**
    * @generated
    */
    private String alphabeticCode;
    
    /**
    * @generated
    */
    private String numericCode;
    
    /**
    * @generated
    */
    private String majorUnitSymbol;
    
    /**
    * @generated
    */
    private String minorUnitSymbol;
    
    /**
    * @generated
    */
    private double ratioOfMinorToMajorUnit;
    
    /**
    * @generated
    */
    private TimeDate introductionDate;
    
    /**
    * @generated
    */
    private TimeDate expirationDate;
    
    
    /**
    * @generated
    */
    private Set<Locale> acceptedIn;
    
    

    /**
    * @generated
    */
    public String getAlphabeticCode() {
        return this.alphabeticCode;
    }
    
    /**
    * @generated
    */
    public void setAlphabeticCode(String alphabeticCode) {
        this.alphabeticCode = alphabeticCode;
    }
    
    
    /**
    * @generated
    */
    public String getNumericCode() {
        return this.numericCode;
    }
    
    /**
    * @generated
    */
    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }
    
    
    /**
    * @generated
    */
    public String getMajorUnitSymbol() {
        return this.majorUnitSymbol;
    }
    
    /**
    * @generated
    */
    public void setMajorUnitSymbol(String majorUnitSymbol) {
        this.majorUnitSymbol = majorUnitSymbol;
    }
    
    
    /**
    * @generated
    */
    public String getMinorUnitSymbol() {
        return this.minorUnitSymbol;
    }
    
    /**
    * @generated
    */
    public void setMinorUnitSymbol(String minorUnitSymbol) {
        this.minorUnitSymbol = minorUnitSymbol;
    }
    
    
    /**
    * @generated
    */
    public double getRatioOfMinorToMajorUnit() {
        return this.ratioOfMinorToMajorUnit;
    }
    
    /**
    * @generated
    */
    public void setRatioOfMinorToMajorUnit(double ratioOfMinorToMajorUnit) {
        this.ratioOfMinorToMajorUnit = ratioOfMinorToMajorUnit;
    }
    
    
    /**
    * @generated
    */
    public TimeDate getIntroductionDate() {
        return this.introductionDate;
    }
    
    /**
    * @generated
    */
    public void setIntroductionDate(TimeDate introductionDate) {
        this.introductionDate = introductionDate;
    }
    
    
    /**
    * @generated
    */
    public TimeDate getExpirationDate() {
        return this.expirationDate;
    }
    
    /**
    * @generated
    */
    public void setExpirationDate(TimeDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    
    
    /**
    * @generated
    */
    public Set<Locale> getAcceptedIn() {
        if (this.acceptedIn == null) {
            this.acceptedIn = new HashSet<Locale>();
        }
        return this.acceptedIn;
    }
    
    /**
    * @generated
    */
    public void setAcceptedIn(Set<Locale> acceptedIn) {
        this.acceptedIn = acceptedIn;
    }
    
    
    
}
