package net.liccioni.archetypes.product;

import java.util.HashSet;
import java.util.Set;

/**
 * @generated
 */
public class ProductSet {

    /**
     * @generated
     */
    private String name;


    /**
     * @generated
     */
    private Set<ProductIdentifier> productIdentifier;


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


    //                          Operations                                  


    /**
     * @generated
     */
    public boolean addProductReference(ProductIdentifier reference) {
        //TODO
        return false;
    }


    /**
     * @generated
     */
    public int count(ProductIdentifier reference) {
        //TODO
        return 0;
    }


}
