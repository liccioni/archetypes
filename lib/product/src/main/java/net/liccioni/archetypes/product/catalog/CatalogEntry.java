package net.liccioni.archetypes.product.catalog;

import lombok.Builder;
import net.liccioni.archetypes.product.ProductType;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record CatalogEntry(String catalogIdentifier,
                           String description,
                           Set<ProductType> productTypes,
                           Set<String> category) {
    @Builder(toBuilder = true)
    public CatalogEntry(String catalogIdentifier,
                        String description,
                        Set<ProductType> productTypes,
                        Set<String> category) {
        this.catalogIdentifier = catalogIdentifier;
        this.description = description;
        this.productTypes = Optional.ofNullable(productTypes).orElseGet(HashSet::new);
        this.category = Optional.ofNullable(category).orElseGet(HashSet::new);
    }
}
