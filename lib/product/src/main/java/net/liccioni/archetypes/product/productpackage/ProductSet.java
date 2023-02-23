package net.liccioni.archetypes.product.productpackage;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import net.liccioni.archetypes.product.ProductIdentifier;

@Value
@Builder(toBuilder = true)
public class ProductSet {

    @NonNull
    String name;
    @Builder.Default
    Set<ProductIdentifier> products = new HashSet<>();

    public boolean contains(ProductIdentifier reference) {
        return products.contains(reference);
    }
}
