package net.liccioni.archetypes.product.catalog;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.product.ProductType;

@Data
@SuperBuilder(toBuilder = true)
public abstract class ProductCatalog {

    @Builder.Default
    private final Set<CatalogEntry> catalogEntry = new HashSet<>();

    public abstract boolean addProductType(ProductType productType);

    public abstract boolean addProductType(ProductType productType, String catalogIdentifier);
}
