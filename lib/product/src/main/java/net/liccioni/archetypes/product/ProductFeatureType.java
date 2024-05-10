package net.liccioni.archetypes.product;

import lombok.Builder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Builder(toBuilder = true)
public record ProductFeatureType(String name,
                                 String description,
                                 Set<ProductFeatureInstance> possibleValues) {
    public ProductFeatureType(String name, String description, Set<ProductFeatureInstance> possibleValues) {
        this.name = name;
        this.description = description;
        this.possibleValues = Optional.ofNullable(possibleValues).orElseGet(HashSet::new);
    }
}
