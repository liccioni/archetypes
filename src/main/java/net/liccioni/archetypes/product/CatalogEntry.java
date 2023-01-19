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
    private String catalogIdentifier;
  /**
    * @generated
    */
    private String description;
  /**
    * @generated
    */
    private Set<String> category;
  /**
    * @generated
    */
    private Set<ProductType> productTypes;




  /**
    * @generated
    */
    public String getCatalogIdentifier() {
        return this.catalogIdentifier;
    }

  /**
    * @generated
    */
    public void setCatalogIdentifier(String catalogIdentifier) {
        this.catalogIdentifier = catalogIdentifier;
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
    public Set<String> getCategory() {
        if (this.category == null) {
            this.category = new HashSet<String>();
        }
        return this.category;
    }

  /**
    * @generated
    */
    public void setCategory(Set<String> category) {
        this.category = category;
    }

  /**
    * @generated
    */
    public Set<ProductType> getProductTypes() {
        if (this.productTypes == null) {
            this.productTypes = new HashSet<ProductType>();
        }
        return this.productTypes;
    }

  /**
    * @generated
    */
    public void setProductTypes(Set<ProductType> productTypes) {
        this.productTypes = productTypes;
    }
    
    
    
}
