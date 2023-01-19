package net.liccioni.archetypes.product;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class CatalogEntry {
    
    
    /**
    * @generated
    */
    private Set<ProductType> productType;
    
    

    
    /**
    * @generated
    */
    public Set<ProductType> getProductType() {
        if (this.productType == null) {
            this.productType = new HashSet<ProductType>();
        }
        return this.productType;
    }
    
    /**
    * @generated
    */
    public void setProductType(Set<ProductType> productType) {
        this.productType = productType;
    }
    
    
    
}
