package net.liccioni.archetypes.inventory;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.product.ProductIdentifier;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleOverride;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record ReservationRequest(@NonNull ProductIdentifier productIdentifier,
                                 ReservationIdentifier reservationIdentifier,
                                 Set<PartySummary> requesters,
                                 Set<PartySummary> receivers,
                                 RuleContext context,
                                 TimeDate dateReceived,
                                 Long numberRequested,
                                 Set<RuleOverride> overrides) {

    @Builder(toBuilder = true)
    public ReservationRequest(@NonNull ProductIdentifier productIdentifier,
                              ReservationIdentifier reservationIdentifier,
                              Set<PartySummary> requesters,
                              Set<PartySummary> receivers,
                              RuleContext context,
                              TimeDate dateReceived,
                              Long numberRequested,
                              Set<RuleOverride> overrides) {
        this.productIdentifier = productIdentifier;
        this.reservationIdentifier = reservationIdentifier;
        this.requesters = Optional.ofNullable(requesters).orElseGet(HashSet::new);
        this.receivers = Optional.ofNullable(receivers).orElseGet(HashSet::new);
        this.context = Optional.ofNullable(context).orElseGet(() -> RuleContext.builder().name("").build());
        this.dateReceived = dateReceived;
        this.numberRequested = Optional.ofNullable(numberRequested).orElse(0L);
        this.overrides = Optional.ofNullable(overrides).orElseGet(HashSet::new);
    }
}
