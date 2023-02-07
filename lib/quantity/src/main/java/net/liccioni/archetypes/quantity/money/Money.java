package net.liccioni.archetypes.quantity.money;


import lombok.Getter;
import net.liccioni.archetypes.quantity.Quantity;


public class Money extends Quantity {

    @Getter
    private final Currency currency;

    public Money(final Number amount, final Currency currency) {
        super(amount, currency);
        this.currency = currency;
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
