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

    public boolean addBody(PropositionOfInclusion conditionProposition) {

        return body.add(conditionProposition);
    }
}
