package net.liccioni.archetypes.relationship;


import java.util.Set;
import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleSet;

@Value
@Builder
public class PartyRelationshipType {

    String name;
    String description;
    RuleSet requirementsForRelationship;
    Set<PartyRelationshipConstraint> constraints;

    public boolean canFormRelationship(PartyRole client, PartyRole supplier) {
        return this.constraints.stream().allMatch(p -> p.canFormRelationship(client, supplier));
    }

    public boolean canFormRelationship(PartyRole client, PartyRole supplier, RuleContext context) {
        return this.canFormRelationship(client, supplier) &&
                this.requirementsForRelationship.evaluate(context);
    }
}
