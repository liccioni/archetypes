package net.liccioni.archetypes.product.catalog;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.product.ProductType;

@Value
@Builder(toBuilder = true)
public class CatalogEntry {

    String catalogIdentifier;
    String description;
    @Builder.Default
    Set<ProductType> productTypes = new HashSet<>();
    @Builder.Default
    Set<String> category = new HashSet<>();
}
