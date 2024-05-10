package net.liccioni.archetypes.product;


import lombok.Builder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record ProductFeatureInstance(String value,
                                     ProductFeatureType productFeatureType,
                                     Set<String> possibleValues) {
    @Builder(toBuilder = true)
    public ProductFeatureInstance(String value, ProductFeatureType productFeatureType, Set<String> possibleValues) {
        this.value = value;
        this.productFeatureType = productFeatureType;
        this.possibleValues = Optional.ofNullable(possibleValues).orElseGet(HashSet::new);
    }

    public String getName() {
        return productFeatureType.name();
    }

    public String getDescription() {
        return productFeatureType.description();
    }
}
