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

@Data
@SuperBuilder(toBuilder = true)
public class ProductType {

    private final ProductIdentifier productIdentifier;
    @NonNull
    private final String name;
    private final String description;
    @Builder.Default
    private final Set<ProductFeatureType> mandatoryFeatureTypes = new HashSet<>();
    @Builder.Default
    private final Set<ProductFeatureType> optionalFeatureTypes = new HashSet<>();
    @Builder.Default
    private final Set<Price> prices = new HashSet<>();

    public List<Price> getPrices(RuleContext context) {
        return prices.stream().filter(p -> p.isValid(context, Collections.emptySet()))
                .collect(Collectors.toList());
    }

    public List<Price> getPrices(TimeDate validFrom, TimeDate validTo) {

        return prices.stream()
                .filter(p -> isValid(p.getValidFrom(), priceFrom -> priceFrom.isAfter(validFrom.getValue())))
                .filter(p -> isValid(p.getValidTo(), priceTo -> priceTo.isBefore(validTo.getValue())))
                .collect(Collectors.toList());
    }

    private boolean isValid(final TimeDate priceValidFrom,
                            final Predicate<Instant> isValid) {
        return Optional.ofNullable(priceValidFrom)
                .map(TimeDate::getValue)
                .filter(isValid)
                .isPresent();
    }
}
