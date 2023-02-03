package net.liccioni.archetypes.quantity;

import lombok.Data;

@Data
public class SimpleUnit implements Unit {

    private final String name;
    private final String symbol;
    private final String definition;
    private final SystemOfUnits systemOfUnits;
}
