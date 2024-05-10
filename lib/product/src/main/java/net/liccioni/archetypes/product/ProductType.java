package net.liccioni.archetypes.product;

import java.time.Instant;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.product.price.Price;
import net.liccioni.archetypes.rule.RuleContext;

public interface ProductType {

    ProductIdentifier productIdentifier();
    String name();
    String description();
    Set<ProductFeatureType> mandatoryFeatureTypes();
    Set<ProductFeatureType> optionalFeatureTypes();
    Set<Price> prices();

    default List<Price> getPrices(RuleContext context) {
        return prices().stream().filter(p -> p.isValid(context, Collections.emptySet()))
                .collect(Collectors.toList());
    }

    default List<Price> getPrices(TimeDate validFrom, TimeDate validTo) {

        return prices().stream()
                .filter(p -> isValid(p.validFrom(), priceFrom -> priceFrom.isAfter(validFrom.value())))
                .filter(p -> isValid(p.validTo(), priceTo -> priceTo.isBefore(validTo.value())))
                .collect(Collectors.toList());
    }

    private boolean isValid(final TimeDate priceValidFrom,
                            final Predicate<Instant> isValid) {
        return Optional.ofNullable(priceValidFrom)
                .map(TimeDate::value)
                .filter(isValid)
                .isPresent();
    }
}
