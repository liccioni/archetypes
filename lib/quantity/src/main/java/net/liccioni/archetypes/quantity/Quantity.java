package net.liccioni.archetypes.quantity;


import java.math.BigDecimal;
import java.math.RoundingMode;

public interface Quantity {

    BigDecimal amount();

    Metric metric();

    default Quantity round(RoundingPolicy policy) {
        return new QuantityRecord(policy.round(amount()), metric());
    }

    default boolean equalTo(Quantity quantity) {
        return this.equals(quantity);
    }

    default boolean greaterThan(Quantity quantity) {
        if (!metric().isEqualTo(quantity.metric())) {
            throw new IllegalArgumentException("Different units, cannot compare " + this + " and " + quantity);
        }
        return amount().compareTo(quantity.amount()) > 0;
    }

    default boolean lessThan(Quantity quantity) {
        if (!metric().isEqualTo(quantity.metric())) {
            throw new IllegalArgumentException("Different units, cannot compare " + this + " and " + quantity);
        }
        return amount().compareTo(quantity.amount()) < 0;
    }

    default Quantity add(Quantity quantity) {
        if (!metric().isEqualTo(quantity.metric())) {
            throw new IllegalArgumentException("Different units, cannot add " + this + " and " + quantity);
        }
        return this.withAmount(this.amount().add(quantity.amount()));
    }

    Quantity withAmount(BigDecimal amount);

    default Quantity subtract(Quantity quantity) {
        if (!metric().isEqualTo(quantity.metric())) {
            throw new IllegalArgumentException("Different units, cannot subtract " + this + " and " + quantity);
        }
        return this.withAmount(this.amount().subtract(quantity.amount()));
    }

    default Quantity multiply(double multiplier) {
        return this.withAmount(this.amount().multiply(BigDecimal.valueOf(multiplier)));
    }

    default Quantity multiply(Quantity quantity) {
        final var derivedMetric = new DerivedUnit(metric(),
                new DerivedUnitTerm(1, this.metric()),
                new DerivedUnitTerm(1, quantity.metric()));
        return new QuantityRecord(this.amount().multiply(quantity.amount()), derivedMetric);
    }

    default Quantity divide(double divisor) {
        return this.withAmount(this.amount().divide(BigDecimal.valueOf(divisor), RoundingMode.UP));
    }

    default Quantity divide(Quantity quantity) {
        return Quantity.divide(this, quantity);
    }

    static Quantity divide(Quantity instance, Quantity other) {
        final var derivedMetric = new DerivedUnit(instance.metric(),
                new DerivedUnitTerm(1, instance.metric()),
                new DerivedUnitTerm(-1, other.metric()));
        return new QuantityRecord(instance.amount().divide(other.amount(), RoundingMode.UP), derivedMetric);
    }
}
