package net.liccioni.archetypes.relationship;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.party.Party;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleSet;

@Value
@Builder(toBuilder = true)
public class PartyRoleType {

    String name;
    String description;
    @Builder.Default
    RuleSet requirementsForRole = new RuleSet("");
    @Builder.Default
    Set<PartyRoleConstraint> constraints = new HashSet<>();
    @Builder.Default
    Set<Responsibility> optionalResponsibilities = new HashSet<>();
    @Builder.Default
    Set<Responsibility> mandatoryResponsibilities = new HashSet<>();

    public boolean canPlayRole(Party party) {
        return this.constraints.stream().allMatch(constraint -> constraint.canPlayRole(party));
    }

    public boolean canPlayRole(Party party, RuleContext context) {
        return this.canPlayRole(party) && requirementsForRole.evaluate(context);
    }
}
