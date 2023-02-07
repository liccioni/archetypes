package net.liccioni.archetypes.relationship;


import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleSet;

@Value
@Builder(toBuilder = true)
public class PartyRelationshipType {

    @NonNull
    String name;
    String description;
    @Builder.Default
    RuleSet requirementsForRelationship = new RuleSet("");
    @Builder.Default
    Set<PartyRelationshipConstraint> constraints = new HashSet<>();

    public boolean canFormRelationship(PartyRole client, PartyRole supplier) {
        return this.constraints.stream().allMatch(p -> p.canFormRelationship(client, supplier));
    }

    public boolean canFormRelationship(PartyRole client, PartyRole supplier, RuleContext context) {
        return this.canFormRelationship(client, supplier) &&
                this.requirementsForRelationship.evaluate(context);
    }
}
