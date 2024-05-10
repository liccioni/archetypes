package net.liccioni.archetypes.product.measured;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.product.ProductFeatureType;
import net.liccioni.archetypes.product.ProductIdentifier;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.product.price.Price;
import net.liccioni.archetypes.quantity.Metric;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record MeasuredProductType(ProductIdentifier productIdentifier,
                                  @NonNull String name,
                                  String description,
                                  Set<ProductFeatureType> mandatoryFeatureTypes,
                                  Set<ProductFeatureType> optionalFeatureTypes,
                                  Set<Price> prices,
                                  Metric preferredMetric,
                                  Set<Metric> possibleMetrics) implements ProductType {


    @Builder(toBuilder = true)
    public MeasuredProductType(ProductIdentifier productIdentifier,
                               @NonNull String name,
                               String description,
                               Set<ProductFeatureType> mandatoryFeatureTypes,
                               Set<ProductFeatureType> optionalFeatureTypes,
                               Set<Price> prices,
                               Metric preferredMetric,
                               Set<Metric> possibleMetrics) {
        this.productIdentifier = productIdentifier;
        this.name = name;
        this.description = description;
        this.mandatoryFeatureTypes = Optional.ofNullable(mandatoryFeatureTypes).orElseGet(HashSet::new);
        this.optionalFeatureTypes = Optional.ofNullable(optionalFeatureTypes).orElseGet(HashSet::new);
        this.prices = Optional.ofNullable(prices).orElseGet(HashSet::new);
        this.preferredMetric = preferredMetric;
        this.possibleMetrics = Optional.ofNullable(possibleMetrics).orElseGet(HashSet::new);
    }
}
