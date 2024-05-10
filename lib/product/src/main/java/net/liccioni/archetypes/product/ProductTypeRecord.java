package net.liccioni.archetypes.product;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.product.price.Price;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record ProductTypeRecord(ProductIdentifier productIdentifier,
                                @NonNull String name,
                                String description,
                                Set<ProductFeatureType> mandatoryFeatureTypes,
                                Set<ProductFeatureType> optionalFeatureTypes,
                                Set<Price> prices) implements ProductType {

    @Builder(toBuilder = true)
    public ProductTypeRecord(ProductIdentifier productIdentifier,
                             @NonNull String name,
                             String description,
                             Set<ProductFeatureType> mandatoryFeatureTypes,
                             Set<ProductFeatureType> optionalFeatureTypes,
                             Set<Price> prices) {
        this.productIdentifier = productIdentifier;
        this.name = name;
        this.description = description;
        this.mandatoryFeatureTypes = Optional.ofNullable(mandatoryFeatureTypes).orElseGet(HashSet::new);
        this.optionalFeatureTypes = Optional.ofNullable(optionalFeatureTypes).orElseGet(HashSet::new);
        this.prices = Optional.ofNullable(prices).orElseGet(HashSet::new);
    }
}
