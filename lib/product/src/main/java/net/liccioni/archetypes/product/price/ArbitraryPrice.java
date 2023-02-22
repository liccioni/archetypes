package net.liccioni.archetypes.product.price;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.party.PartySignature;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class ArbitraryPrice extends Price {

    @Builder.Default
    Set<PartySignature> approvedBy = new HashSet<>();
}
