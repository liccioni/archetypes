package net.liccioni.archetypes.product;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class ProductType {
    
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
    private Set<ProductFeatureType> optionalFeatureTypes;
    
    /**
    * @generated
    */
    private Set<Price> prices;
    
    /**
    * @generated
    */
    private ProductIdentifier productIdentifier;
    
    /**
    * @generated
    */
    private Set<ProductFeatureType> mandatoryFeatureTypes;
    
    

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
    public Set<ProductFeatureType> getMandatoryFeatureTypes() {
        if (this.mandatoryFeatureTypes == null) {
            this.mandatoryFeatureTypes = new HashSet<ProductFeatureType>();
        }
        return this.mandatoryFeatureTypes;
    }
    
    /**
    * @generated
    */
    public void setMandatoryFeatureTypes(Set<ProductFeatureType> mandatoryFeatureTypes) {
        this.mandatoryFeatureTypes = mandatoryFeatureTypes;
    }
    
    
    /**
    * @generated
    */
    public Set<ProductFeatureType> getOptionalFeatureTypes() {
        if (this.optionalFeatureTypes == null) {
            this.optionalFeatureTypes = new HashSet<ProductFeatureType>();
        }
        return this.optionalFeatureTypes;
    }
    
    /**
    * @generated
    */
    public void setOptionalFeatureTypes(Set<ProductFeatureType> optionalFeatureTypes) {
        this.optionalFeatureTypes = optionalFeatureTypes;
    }
    
    
    /**
    * @generated
    */
    public Set<Price> getPrices() {
        if (this.prices == null) {
            this.prices = new HashSet<Price>();
        }
        return this.prices;
    }
    
    /**
    * @generated
    */
    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }
    
    
    /**
    * @generated
    */
    public ProductIdentifier getProductIdentifier() {
        return this.productIdentifier;
    }
    
    /**
    * @generated
    */
    public void setProductIdentifier(ProductIdentifier productIdentifier) {
        this.productIdentifier = productIdentifier;
    }
    
    
    

    //                          Operations                                  
    
    
    
    /**
    * @generated
    */
    public List<Price> getPrices(RuleContext context)
    {
        //TODO
        return null;
    }
    
    
}
