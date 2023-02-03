package net.liccioni.archetypes.quantity;

import lombok.Value;

@Value
public class DerivedUnitTerm {

    int power;
    Metric unit;
}
