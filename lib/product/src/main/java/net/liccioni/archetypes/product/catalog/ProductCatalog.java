package net.liccioni.archetypes.product.catalog;

import net.liccioni.archetypes.product.ProductType;

import java.util.Set;

public interface ProductCatalog {

    Set<CatalogEntry> catalogEntry();

    boolean addProductType(ProductType productType);

    boolean addProductType(ProductType productType, String catalogIdentifier);
}
