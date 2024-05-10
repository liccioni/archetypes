package net.liccioni.archetypes.product.service;


import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.product.ProductFeatureType;
import net.liccioni.archetypes.product.ProductIdentifier;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.product.price.Price;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record ServiceType(ProductIdentifier productIdentifier,
                          @NonNull String name,
                          String description,
                          Set<ProductFeatureType> mandatoryFeatureTypes,
                          Set<ProductFeatureType> optionalFeatureTypes,
                          Set<Price> prices,
                          TimeDate startPeriodOfOperation,
                          TimeDate endPeriodOfOperation) implements ProductType {

    @Builder(toBuilder = true)
    public ServiceType(ProductIdentifier productIdentifier,
                       @NonNull String name,
                       String description,
                       Set<ProductFeatureType> mandatoryFeatureTypes,
                       Set<ProductFeatureType> optionalFeatureTypes,
                       Set<Price> prices,
                       TimeDate startPeriodOfOperation,
                       TimeDate endPeriodOfOperation) {
        this.productIdentifier = productIdentifier;
        this.name = name;
        this.description = description;
        this.mandatoryFeatureTypes = Optional.ofNullable(mandatoryFeatureTypes).orElseGet(HashSet::new);
        this.optionalFeatureTypes = Optional.ofNullable(optionalFeatureTypes).orElseGet(HashSet::new);
        this.prices = Optional.ofNullable(prices).orElseGet(HashSet::new);
        this.startPeriodOfOperation = startPeriodOfOperation;
        this.endPeriodOfOperation = endPeriodOfOperation;
    }
}
