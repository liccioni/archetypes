package net.liccioni.archetypes.product.productpackage;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.product.ProductFeatureType;
import net.liccioni.archetypes.product.ProductIdentifier;
import net.liccioni.archetypes.product.price.Price;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record PackageTypeRecord(ProductIdentifier productIdentifier,
                                @NonNull String name,
                                String description,
                                Set<ProductFeatureType> mandatoryFeatureTypes,
                                Set<ProductFeatureType> optionalFeatureTypes,
                                Set<Price> prices,
                                Set<ProductSet> productSet,
                                Set<ProductIdentifier> components,
                                Set<PropositionOfInclusion> propositionOfInclusion) implements PackageType {
    @Builder(toBuilder = true)
    public PackageTypeRecord(ProductIdentifier productIdentifier,
                             @NonNull String name,
                             String description,
                             Set<ProductFeatureType> mandatoryFeatureTypes,
                             Set<ProductFeatureType> optionalFeatureTypes,
                             Set<Price> prices,
                             Set<ProductSet> productSet,
                             Set<ProductIdentifier> components,
                             Set<PropositionOfInclusion> propositionOfInclusion) {
        this.productIdentifier = productIdentifier;
        this.name = name;
        this.description = description;
        this.mandatoryFeatureTypes = Optional.ofNullable(mandatoryFeatureTypes).orElseGet(HashSet::new);
        this.optionalFeatureTypes = Optional.ofNullable(optionalFeatureTypes).orElseGet(HashSet::new);
        this.prices = Optional.ofNullable(prices).orElseGet(HashSet::new);
        this.propositionOfInclusion = Optional.ofNullable(propositionOfInclusion).orElseGet(HashSet::new);
        this.productSet = Optional.ofNullable(productSet).orElseGet(() -> PackageType.buildProductSets(this.propositionOfInclusion));
        this.components = Optional.ofNullable(components).orElseGet(() -> PackageType.buildComponents(this.propositionOfInclusion));
    }
}
