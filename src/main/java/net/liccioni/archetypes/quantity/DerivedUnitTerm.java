package net.liccioni.archetypes.quantity;

public class DerivedUnitTerm {

    private final int power;
    private final Metric unit;

    public DerivedUnitTerm(final int power, final Metric unit) {
        this.power = power;
        this.unit = unit;
    }

    public int getPower() {
        return power;
    }

    public Metric getUnit() {
        return unit;
    }
}
