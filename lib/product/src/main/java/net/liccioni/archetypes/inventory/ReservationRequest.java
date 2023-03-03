package net.liccioni.archetypes.inventory;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.product.ProductIdentifier;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleOverride;

@Value
@Builder(toBuilder = true)
public class ReservationRequest {

    @NonNull
    ProductIdentifier productIdentifier;
    ReservationIdentifier reservationIdentifier;
    @Builder.Default
    Set<PartySummary> requesters = new HashSet<>();
    @Builder.Default
    Set<PartySummary> receivers = new HashSet<>();
    @Builder.Default
    RuleContext context = RuleContext.builder().build();
    TimeDate dateReceived;
    @Builder.Default
    Long numberRequested = 0L;
    @Builder.Default
    Set<RuleOverride> overrides = new HashSet<>();
}
