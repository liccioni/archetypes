package net.liccioni.archetypes.product;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class ProductFeatureType {
    
    /**
    * @generated
    */
    private String name;
    
    /**
    * @generated
    */
    private String description;
    
    
    /**
    * @generated
    */
    private Set<ProductFeatureInstance> possibleValues;
    
    

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
    public String getDescription() {
        return this.description;
    }
    
    /**
    * @generated
    */
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    /**
    * @generated
    */
    public Set<ProductFeatureInstance> getPossibleValues() {
        if (this.possibleValues == null) {
            this.possibleValues = new HashSet<ProductFeatureInstance>();
        }
        return this.possibleValues;
    }
    
    /**
    * @generated
    */
    public void setPossibleValues(Set<ProductFeatureInstance> possibleValues) {
        this.possibleValues = possibleValues;
    }
    
    
    
}
