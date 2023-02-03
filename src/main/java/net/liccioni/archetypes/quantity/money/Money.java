package net.liccioni.archetypes.quantity.money;


import net.liccioni.archetypes.quantity.Quantity;

public class Money extends Quantity {
    private final Currency currency;

    public Money(final Number amount, final Currency currency) {
        super(amount, currency);
        this.currency = currency;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    @Override
    public Quantity multiply(final Quantity quantity) {
        throw new UnsupportedOperationException("Money cannot be multiplied by anything " + this + " * " + quantity);
    }

    @Override
    public Quantity divide(final Quantity quantity) {
        if (quantity instanceof Money) {
            throw new IllegalArgumentException("Money cannot be divided by money " + this + " / " + quantity);
        }
        return super.divide(quantity);
    }
}
