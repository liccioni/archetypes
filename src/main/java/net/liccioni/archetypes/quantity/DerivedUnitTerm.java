package net.liccioni.archetypes.quantity;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DerivedUnitTerm)) {
            return false;
        }
        DerivedUnitTerm that = (DerivedUnitTerm) o;
        return unit.equals(that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit);
    }

    @Override
    public String toString() {
        return "DerivedUnitTerm{" +
                "power=" + power +
                ", unit=" + unit +
                '}';
    }
}
