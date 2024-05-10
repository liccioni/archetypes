package net.liccioni.archetypes.product.productpackage;

import net.liccioni.archetypes.product.ProductIdentifier;
import net.liccioni.archetypes.product.ProductType;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

public interface PackageType extends ProductType {

    Set<ProductSet> productSet();

    Set<ProductIdentifier> components();

    Set<PropositionOfInclusion> propositionOfInclusion();

    default boolean validate(final PackageInstance packageInstance) {

        return propositionOfInclusion().stream()
                .filter(p->Objects.nonNull(p.productSet()))
                .collect(groupingBy(PropositionOfInclusion::productSet,
                        reducing((poi1, poi2) -> PropositionOfInclusionRecord.builder()
                                .name(poi1.name().concat("_").concat(poi2.name()))
                                .productSet(poi1.productSet())
                                .maximum(poi1.maximum() + poi2.maximum())
                                .minimum(poi1.minimum() + poi2.minimum())
                                .build())))
                .values().stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .allMatch(p -> p.isSubSetOf(packageInstance));
    }

    static Set<ProductSet> buildProductSets(Set<PropositionOfInclusion> propositionOfInclusion) {
        assert propositionOfInclusion != null;
        return propositionOfInclusion.stream()
                .map(PropositionOfInclusion::productSet)
                .filter(Objects::nonNull).collect(Collectors.toSet());
    }

    static Set<ProductIdentifier> buildComponents(Set<PropositionOfInclusion> propositionOfInclusion) {
        assert propositionOfInclusion != null;
        return propositionOfInclusion.stream()
                .map(PropositionOfInclusion::productSet)
                .filter(Objects::nonNull)
                .flatMap(p -> p.products().stream())
                .collect(Collectors.toSet());
    }
}
