package net.liccioni.archetypes.quantity;

import lombok.Builder;

import java.math.BigDecimal;

public record QuantityRecord(BigDecimal amount, Metric metric) implements Quantity {
    @Builder(toBuilder = true)
    public QuantityRecord(Number amount, Metric metric) {
        this(BigDecimal.valueOf(amount.doubleValue()), metric);
    }

    @Override
    public Quantity withAmount(BigDecimal amount) {
        return this.toBuilder().amount(amount).build();
    }
}
