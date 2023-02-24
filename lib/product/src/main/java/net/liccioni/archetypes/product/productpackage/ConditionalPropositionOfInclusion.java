package net.liccioni.archetypes.product.productpackage;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class ConditionalPropositionOfInclusion extends PropositionOfInclusion {

    PropositionOfInclusion condition;

    @Builder.Default
    Set<PropositionOfInclusion> body = new HashSet<>();

    @Override
    public void setTargetPackage(final PackageInstance targetPackage) {
        condition.setTargetPackage(targetPackage);
        body.forEach(p -> p.setTargetPackage(targetPackage));
    }

    @Override
    public ProductSet getProductSet() {
        if (condition.isSubSetOf()) {
            return ProductSet.builder()
                    .name(condition.getName())
                    .products(body.stream().flatMap(p -> p.getProductSet().getProducts().stream())
                            .collect(Collectors.toSet()))
                    .build();
        }
        return ProductSet.builder()
                .name(condition.getName())
                .build();
    }

    @Override
    public boolean isSubSetOf() {
        if (condition.isSubSetOf()) {
            return body.stream().allMatch(PropositionOfInclusion::isSubSetOf);
        }
        return true;
    }
}
