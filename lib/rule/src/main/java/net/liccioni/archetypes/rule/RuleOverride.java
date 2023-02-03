package net.liccioni.archetypes.rule;

import lombok.Value;
import net.liccioni.archetypes.common.TimeDate;

@Value
public class RuleOverride {

    String ruleName;
    boolean override;
    String why;
    TimeDate when;

    public RuleOverride(final String ruleName, final boolean override) {
        this.ruleName = ruleName;
        this.override = override;
        this.why = "";
        this.when = new TimeDate();
    }

    public RuleOverride(final String ruleName, final boolean override, final String why,
                        final TimeDate when) {
        this.ruleName = ruleName;
        this.override = override;
        this.why = why;
        this.when = when;
    }
}
