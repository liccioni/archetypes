package net.liccioni.archetypes.relationship;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.party.Party;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleSet;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Builder(toBuilder = true)
public record PartyRoleType(@NonNull String name,
                            String description,
                            RuleSet requirementsForRole,
                            Set<PartyRoleConstraint> constraints,
                            Set<Responsibility> optionalResponsibilities,
                            Set<Responsibility> mandatoryResponsibilities) {
    public PartyRoleType(@NonNull String name,
                         String description,
                         RuleSet requirementsForRole,
                         Set<PartyRoleConstraint> constraints,
                         Set<Responsibility> optionalResponsibilities,
                         Set<Responsibility> mandatoryResponsibilities) {
        this.name = name;
        this.description = description;
        this.requirementsForRole = Optional.ofNullable(requirementsForRole).orElseGet(() -> new RuleSet(""));
        this.constraints = Optional.ofNullable(constraints).orElseGet(HashSet::new);
        this.optionalResponsibilities = Optional.ofNullable(optionalResponsibilities).orElseGet(HashSet::new);
        this.mandatoryResponsibilities = Optional.ofNullable(mandatoryResponsibilities).orElseGet(HashSet::new);
    }

    public boolean canPlayRole(Party party) {
        return this.constraints.stream().allMatch(constraint -> constraint.canPlayRole(party));
    }

    public boolean canPlayRole(Party party, RuleContext context) {
        return this.canPlayRole(party) && requirementsForRole.evaluate(context);
    }
}
