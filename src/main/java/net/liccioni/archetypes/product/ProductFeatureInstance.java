package net.liccioni.archetypes.product;


import java.util.HashSet;
import java.util.Set;

/**
 * @generated
 */
public class ProductFeatureInstance {

    /**
     * @generated
     */
    private String value;


    /**
     * @generated
     */
    private Set<String> possibleValues;


    /**
     * @generated
     */
    private ProductFeatureType productFeatureType;


    /**
     * @generated
     */
    public String getValue() {
        return this.value;
    }

    /**
     * @generated
     */
    public void setValue(String value) {
        this.value = value;
    }


    /**
     * @generated
     */
    public Set<String> getPossibleValues() {
        if (this.possibleValues == null) {
            this.possibleValues = new HashSet<String>();
        }
        return this.possibleValues;
    }

    /**
     * @generated
     */
    public void setPossibleValues(Set<String> possibleValues) {
        this.possibleValues = possibleValues;
    }

    /**
     * @generated
     */
    public ProductFeatureType getProductFeatureType() {
        return this.productFeatureType;
    }

    /**
     * @generated
     */
    public void setProductFeatureType(ProductFeatureType productFeatureType) {
        this.productFeatureType = productFeatureType;
    }


    //                          Operations


    /**
     * @generated
     */
    public String getName() {
        //TODO
        return "";
    }


    /**
     * @generated
     */
    public String getDescription() {
        //TODO
        return "";
    }
}
