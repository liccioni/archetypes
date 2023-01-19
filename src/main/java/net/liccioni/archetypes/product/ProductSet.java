package net.liccioni.archetypes.product;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class ProductSet {
    
    
    /**
    * @generated
    */
    private Set<ProductIdentifier> productIdentifier;
    
    

    
    /**
    * @generated
    */
    public Set<ProductIdentifier> getProductIdentifier() {
        if (this.productIdentifier == null) {
            this.productIdentifier = new HashSet<ProductIdentifier>();
        }
        return this.productIdentifier;
    }
    
    /**
    * @generated
    */
    public void setProductIdentifier(Set<ProductIdentifier> productIdentifier) {
        this.productIdentifier = productIdentifier;
    }
    
    
    
}
