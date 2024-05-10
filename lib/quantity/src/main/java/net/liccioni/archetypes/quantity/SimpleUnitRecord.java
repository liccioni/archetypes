package net.liccioni.archetypes.quantity;

import lombok.Builder;

@Builder(toBuilder = true)
public record SimpleUnitRecord(String name,
                               String symbol,
                               String definition,
                               SystemOfUnits systemOfUnits) implements SimpleUnit {
}
