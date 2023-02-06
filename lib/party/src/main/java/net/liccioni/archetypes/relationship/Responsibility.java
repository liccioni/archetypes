package net.liccioni.archetypes.relationship;


import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.rule.RuleSet;

@Value
@Builder(toBuilder = true)
public class Responsibility {

    String name;
    String description;
    RuleSet conditionsOfSatisfaction;
    RuleSet requirementsForResponsibility;
}
