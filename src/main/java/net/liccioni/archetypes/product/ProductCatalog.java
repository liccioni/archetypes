package net.liccioni.archetypes.product;

import java.util.HashSet;
import java.util.Set;

/**
 * @generated
 */
public abstract class ProductCatalog {


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


    //                          Operations                                  


    /**
     * @generated
     */
    public abstract boolean addProductType(ProductType productType);


    /**
     * @generated
     */
    public abstract boolean addProductType(ProductType productType, String catalogIdentifier);


}
