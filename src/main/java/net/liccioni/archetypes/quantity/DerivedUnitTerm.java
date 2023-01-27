package net.liccioni.archetypes.quantity;

import java.util.Objects;

public class DerivedUnitTerm {

    private final int power;
    private final Unit unit;

    public DerivedUnitTerm(final int power, final Unit unit) {
        this.power = power;
        this.unit = unit;
    }

    public int getPower() {
        return power;
    }

    public Unit getUnit() {
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
        return power == that.power && unit.equals(that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, unit);
    }
}
