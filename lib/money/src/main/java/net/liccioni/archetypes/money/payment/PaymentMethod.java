package net.liccioni.archetypes.money.payment;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public abstract class PaymentMethod {
}
