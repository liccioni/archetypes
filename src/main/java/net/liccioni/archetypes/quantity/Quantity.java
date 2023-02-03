package net.liccioni.archetypes.quantity;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Quantity {

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

    public BigDecimal getAmount() {
        return amount;
    }

    public Metric getMetric() {
        return metric;
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
        return new Quantity(this.amount.add(quantity.amount), this.metric);
    }

    public Quantity subtract(Quantity quantity) {
        if (!metric.isEqualTo(quantity.metric)) {
            throw new IllegalArgumentException("Different units, cannot subtract " + this + " and " + quantity);
        }
        return new Quantity(this.amount.subtract(quantity.amount), this.metric);
    }

    public Quantity multiply(double multiplier) {
        return new Quantity(this.amount.multiply(BigDecimal.valueOf(multiplier)), this.metric);
    }

    public Quantity multiply(Quantity quantity) {
        final var derivedMetric = new DerivedUnit(metric,
                new DerivedUnitTerm(1, this.metric),
                new DerivedUnitTerm(1, quantity.metric));
        return new Quantity(this.amount.multiply(quantity.amount), derivedMetric);
    }

    public Quantity divide(double divisor) {
        return new Quantity(this.amount.divide(BigDecimal.valueOf(divisor), RoundingMode.UP), this.metric);
    }

    public Quantity divide(Quantity quantity) {
        final var derivedMetric = new DerivedUnit(metric,
                new DerivedUnitTerm(1, this.metric),
                new DerivedUnitTerm(-1, quantity.metric));
        return new Quantity(this.amount.divide(quantity.amount, RoundingMode.UP), derivedMetric);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Quantity)) {
            return false;
        }
        Quantity quantity = (Quantity) o;
        return amount.equals(quantity.amount) && metric.isEqualTo(quantity.metric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, metric);
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "amount=" + amount +
                ", metric=" + metric +
                '}';
    }
}
