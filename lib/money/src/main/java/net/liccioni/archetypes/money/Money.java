package net.liccioni.archetypes.money;


import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import net.liccioni.archetypes.quantity.Quantity;

@ToString(callSuper = true)
public class Money extends Quantity {

    @With
    private final BigDecimal amount;

    @Getter
    @ToString.Exclude
    private final Currency currency;

    @Builder(builderMethodName = "moneyBuilder")
    public Money(final Number amount, @NonNull final Currency currency) {
        super(amount, currency);
        this.currency = currency;
        this.amount = super.getAmount();
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
