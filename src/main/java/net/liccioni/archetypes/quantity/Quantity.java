package net.liccioni.archetypes.quantity;


import java.math.BigDecimal;
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


    //                          Operations


    /**
     * @generated
     */
    public Quantity round(RoundingPolicy policy) {
        return new Quantity(policy.round(this.amount), this.metric);
    }

    /**
     * @generated
     */
    public boolean equalTo(Quantity quantity) {
        //TODO
        return false;
    }

    /**
     * @generated
     */
    public boolean greaterThan(Quantity quantity) {
        //TODO
        return false;
    }

    /**
     * @generated
     */
    public boolean lessThan(Quantity quantity) {
        //TODO
        return false;
    }

    /**
     * @generated
     */
    public Quantity add(Quantity quantity) {
        if (!this.metric.equals(quantity.metric)) {
            throw new IllegalArgumentException("Different units, cannot add " + this + " and " + quantity);
        }
        return new Quantity(this.amount.add(quantity.amount), this.metric);
    }

    /**
     * @generated
     */
    public Quantity subtract(Quantity quantity) {
        if (!this.metric.equals(quantity.metric)) {
            throw new IllegalArgumentException("Different units, cannot subtract " + this + " and " + quantity);
        }
        return new Quantity(this.amount.subtract(quantity.amount), this.metric);
    }

    /**
     * @generated
     */
    public Quantity multiply(double multiplier) {
        return new Quantity(this.amount.multiply(BigDecimal.valueOf(multiplier)), this.metric);
    }

    /**
     * @generated
     */
    public Quantity multiply(Quantity quantity) {
        final var derivedMetric = new DerivedUnit(SystemOfUnits.INTERNATIONAL_SYSTEM_OF_UNITS);
        derivedMetric.addTerm(new DerivedUnitTerm(1, this.metric));
        derivedMetric.addTerm(new DerivedUnitTerm(1, quantity.metric));
        return new Quantity(this.amount.multiply(quantity.amount), derivedMetric);
    }

    /**
     * @generated
     */
    public Quantity divide(double divisor) {
        //TODO
        return null;
    }

    /**
     * @generated
     */
    public Quantity divide(Quantity quantity) {
        //TODO
        return null;
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
        return amount.equals(quantity.amount) && metric.equals(quantity.metric);
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
