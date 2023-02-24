package net.liccioni.archetypes.product.productpackage;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.product.ProductIdentifier;
import net.liccioni.archetypes.product.ProductType;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class PackageType extends ProductType {

    @Getter(lazy = true)
    Set<ProductSet> productSet = buildProductSets();
    @Getter(lazy = true)
    Set<ProductIdentifier> components = buildComponents();

    @Builder.Default
    Set<PropositionOfInclusion> propositionOfInclusion = new HashSet<>();

    public boolean validate(final PackageInstance packageInstance) {

        return propositionOfInclusion.stream()
                .peek(p -> p.setTargetPackage(packageInstance))
                .collect(groupingBy(PropositionOfInclusion::getProductSet,
                        reducing((poi1, poi2) -> poi1.toBuilder()
                                .name(poi1.getName().concat("_").concat(poi2.getName()))
                                .maximum(poi1.getMaximum() + poi2.getMaximum())
                                .minimum(poi1.getMinimum() + poi2.getMinimum())
                                .targetPackage(packageInstance)
                                .build())))
                .values().stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .allMatch(PropositionOfInclusion::isSubSetOf);
    }

    private Set<ProductSet> buildProductSets() {
        assert propositionOfInclusion != null;
        return propositionOfInclusion.stream().map(PropositionOfInclusion::getProductSet).collect(Collectors.toSet());
    }

    private Set<ProductIdentifier> buildComponents() {
        assert propositionOfInclusion != null;
        return propositionOfInclusion.stream().flatMap(p -> p.getProductSet().getProducts().stream())
                .collect(Collectors.toSet());
    }
}
