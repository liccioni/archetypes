package net.liccioni.archetypes.product;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class ProductCatalog {
    
    
    /**
    * @generated
    */
    private Set<CatalogEntry> catalogEntry;
    
    

    
    /**
    * @generated
    */
    public Set<CatalogEntry> getCatalogEntry() {
        if (this.catalogEntry == null) {
            this.catalogEntry = new HashSet<CatalogEntry>();
        }
        return this.catalogEntry;
    }
    
    /**
    * @generated
    */
    public void setCatalogEntry(Set<CatalogEntry> catalogEntry) {
        this.catalogEntry = catalogEntry;
    }
    
    
    
}
