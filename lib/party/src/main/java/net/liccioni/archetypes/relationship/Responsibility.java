package net.liccioni.archetypes.relationship;


import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import net.liccioni.archetypes.rule.RuleSet;

@Value
@Builder(toBuilder = true)
public class Responsibility {

    @NonNull
    String name;
    String description;
    @Builder.Default
    RuleSet conditionsOfSatisfaction = new RuleSet("conditionsOfSatisfaction");
    @Builder.Default
    RuleSet requirementsForResponsibility = new RuleSet("requirementsForResponsibility");
}
