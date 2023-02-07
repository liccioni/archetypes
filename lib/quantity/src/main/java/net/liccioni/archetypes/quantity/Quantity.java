package net.liccioni.archetypes.quantity;


import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.Data;
import lombok.NonNull;
import lombok.With;

@Data
public class Quantity {

    @With
    @NonNull
    private final BigDecimal amount;

    private final Metric metric;

    public Quantity(final BigDecimal amount, final Metric metric) {
        this.amount = amount;
        this.metric = metric;
    }

    public Quantity(final Number amount, final Metric metric) {
        this.amount = BigDecimal.valueOf(amount.doubleValue());
        this.metric = metric;
    }

    public Quantity round(RoundingPolicy policy) {
        return new Quantity(policy.round(this.amount), this.metric);
    }

    public boolean equalTo(Quantity quantity) {
        return this.equals(quantity);
    }

    public boolean greaterThan(Quantity quantity) {
        if (!metric.isEqualTo(quantity.metric)) {
            throw new IllegalArgumentException("Different units, cannot compare " + this + " and " + quantity);
        }
        return amount.compareTo(quantity.amount) > 0;
    }

    public boolean lessThan(Quantity quantity) {
        if (!metric.isEqualTo(quantity.metric)) {
            throw new IllegalArgumentException("Different units, cannot compare " + this + " and " + quantity);
        }
        return amount.compareTo(quantity.amount) < 0;
    }

    public Quantity add(Quantity quantity) {
        if (!metric.isEqualTo(quantity.metric)) {
            throw new IllegalArgumentException("Different units, cannot add " + this + " and " + quantity);
        }
        return this.withAmount(this.amount.add(quantity.amount));
    }

    public Quantity subtract(Quantity quantity) {
        if (!metric.isEqualTo(quantity.metric)) {
            throw new IllegalArgumentException("Different units, cannot subtract " + this + " and " + quantity);
        }
        return this.withAmount(this.amount.subtract(quantity.amount));
    }

    public Quantity multiply(double multiplier) {
        return this.withAmount(this.amount.multiply(BigDecimal.valueOf(multiplier)));
    }

    public Quantity multiply(Quantity quantity) {
        final var derivedMetric = new DerivedUnit(metric,
                new DerivedUnitTerm(1, this.metric),
                new DerivedUnitTerm(1, quantity.metric));
        return new Quantity(this.amount.multiply(quantity.amount), derivedMetric);
    }

    public Quantity divide(double divisor) {
        return this.withAmount(this.amount.divide(BigDecimal.valueOf(divisor), RoundingMode.UP));
    }

    public Quantity divide(Quantity quantity) {
        final var derivedMetric = new DerivedUnit(metric,
                new DerivedUnitTerm(1, this.metric),
                new DerivedUnitTerm(-1, quantity.metric));
        return new Quantity(this.amount.divide(quantity.amount, RoundingMode.UP), derivedMetric);
    }
}
