package net.liccioni.archetypes.product.productpackage;

import lombok.Builder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record ConditionalPropositionOfInclusion(String name,
                                                ProductSet productSet,
                                                int minimum,
                                                int maximum,
                                                PropositionOfInclusion condition,
                                                Set<PropositionOfInclusion> body) implements PropositionOfInclusion {

    @Builder(toBuilder = true)
    public ConditionalPropositionOfInclusion(String name,
                                             ProductSet productSet,
                                             int minimum,
                                             int maximum,
                                             PropositionOfInclusion condition,
                                             Set<PropositionOfInclusion> body) {
        this.name = name;
        this.productSet = productSet;
        this.minimum = minimum;
        this.maximum = maximum;
        this.condition = condition;
        this.body = Optional.ofNullable(body).orElseGet(HashSet::new);
    }

    @Override
    public boolean isSubSetOf(PackageInstance targetPackage) {
        if (condition.isSubSetOf(targetPackage)) {
            return body.stream().allMatch(p -> p.isSubSetOf(targetPackage));
        }
        return true;
    }
}
