package net.liccioni.archetypes.product.productpackage;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.product.ProductIdentifier;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public record ProductSet(@NonNull String name, Set<ProductIdentifier> products) {

    @Builder(toBuilder = true)
    public ProductSet(@NonNull String name, Set<ProductIdentifier> products) {
        this.name = name;
        this.products = Optional.ofNullable(products).orElseGet(HashSet::new);
    }

    public boolean contains(ProductIdentifier reference) {
        return products.contains(reference);
    }
}
