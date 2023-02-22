package net.liccioni.archetypes.rule;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import net.liccioni.archetypes.common.TimeDate;

@Value
@Builder
public class RuleOverride {

    @NonNull
    String ruleName;
    @NonNull
    Boolean override;
    String why;
    TimeDate when;
}
