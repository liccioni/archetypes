package net.liccioni.archetypes.relationship;

import java.util.Set;
import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.party.Party;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleSet;

@Value
@Builder
public class PartyRoleType {

    String name;
    String description;
    RuleSet requirementsForRole;
    Set<PartyRoleConstraint> constraints;
    Set<Responsibility> optionalResponsibilities;
    Set<Responsibility> mandatoryResponsibilities;

    public boolean canPlayRole(Party party) {
        return this.constraints.stream().allMatch(constraint -> constraint.canPlayRole(party));
    }

    public boolean canPlayRole(Party party, RuleContext context) {
        return this.canPlayRole(party) && requirementsForRole.evaluate(context);
    }
}
