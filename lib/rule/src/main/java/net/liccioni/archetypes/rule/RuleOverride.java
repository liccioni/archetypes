package net.liccioni.archetypes.rule;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.common.TimeDate;

@Builder(toBuilder = true)
public record RuleOverride(@NonNull String ruleName,
                           @NonNull Boolean override,
                           String why,
                           TimeDate when) {
}
