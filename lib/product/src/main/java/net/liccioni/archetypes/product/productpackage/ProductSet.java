package net.liccioni.archetypes.product.productpackage;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.product.ProductIdentifier;

@Value
@Builder(toBuilder = true)
public class ProductSet {

    String name;
    @Builder.Default
    Set<ProductIdentifier> productIdentifier = new HashSet<>();

    public boolean contains(ProductIdentifier reference) {
        return productIdentifier.contains(reference);
    }
}
