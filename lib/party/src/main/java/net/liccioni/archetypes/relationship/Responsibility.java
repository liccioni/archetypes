package net.liccioni.archetypes.relationship;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.rule.RuleSet;

import java.util.Optional;

@Builder(toBuilder = true)
public record Responsibility(@NonNull String name,
                             String description,
                             RuleSet conditionsOfSatisfaction,
                             RuleSet requirementsForResponsibility) {
    public Responsibility(@NonNull String name,
                          String description,
                          RuleSet conditionsOfSatisfaction,
                          RuleSet requirementsForResponsibility) {
        this.name = name;
        this.description = description;
        this.conditionsOfSatisfaction = Optional.ofNullable(conditionsOfSatisfaction)
                .orElseGet(() -> new RuleSet("conditionsOfSatisfaction"));
        this.requirementsForResponsibility = Optional.ofNullable(requirementsForResponsibility)
                .orElseGet(() -> new RuleSet("requirementsForResponsibility"));
    }
}
