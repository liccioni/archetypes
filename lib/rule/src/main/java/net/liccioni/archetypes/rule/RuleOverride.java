package net.liccioni.archetypes.rule;

import java.util.Objects;
import net.liccioni.archetypes.common.TimeDate;

public class RuleOverride {

    private final String ruleName;
    private final boolean override;
    private final String why;
    private final TimeDate when;

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

    public String getRuleName() {
        return ruleName;
    }

    public boolean isOverride() {
        return override;
    }

    public String getWhy() {
        return why;
    }

    public TimeDate getWhen() {
        return when;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RuleOverride)) {
            return false;
        }
        RuleOverride that = (RuleOverride) o;
        return ruleName.equals(that.ruleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruleName);
    }

    @Override
    public String toString() {
        return "RuleOverride{" +
                "ruleName='" + ruleName + '\'' +
                ", override=" + override +
                ", why='" + why + '\'' +
                ", when=" + when +
                '}';
    }
}
