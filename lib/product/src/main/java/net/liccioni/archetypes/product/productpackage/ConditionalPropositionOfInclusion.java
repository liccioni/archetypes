package net.liccioni.archetypes.product.productpackage;

import java.util.HashSet;
import java.util.Set;
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
    public boolean isSubSetOf(final PackageInstance targetPackage) {
        if (condition.isSubSetOf(targetPackage)) {
            return body.stream().allMatch(p -> p.isSubSetOf(targetPackage));
        }
        return true;
    }
}
