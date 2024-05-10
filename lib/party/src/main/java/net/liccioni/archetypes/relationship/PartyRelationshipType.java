package net.liccioni.archetypes.relationship;


import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleSet;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Builder(toBuilder = true)
public record PartyRelationshipType(@NonNull String name,
                                    String description,
                                    RuleSet requirementsForRelationship,
                                    Set<PartyRelationshipConstraint> constraints) {

    @Builder(toBuilder = true)
    public PartyRelationshipType(@NonNull String name,
                                 String description,
                                 RuleSet requirementsForRelationship,
                                 Set<PartyRelationshipConstraint> constraints) {
        this.name = name;
        this.description = description;
        this.requirementsForRelationship = Optional.ofNullable(requirementsForRelationship).orElseGet(() -> new RuleSet(""));
        this.constraints = Optional.ofNullable(constraints).orElseGet(HashSet::new);
    }

    public boolean canFormRelationship(PartyRole client, PartyRole supplier) {
        return this.constraints.stream().allMatch(p -> p.canFormRelationship(client, supplier));
    }

    public boolean canFormRelationship(PartyRole client, PartyRole supplier, RuleContext context) {
        return this.canFormRelationship(client, supplier) &&
                this.requirementsForRelationship.evaluate(context);
    }
}
