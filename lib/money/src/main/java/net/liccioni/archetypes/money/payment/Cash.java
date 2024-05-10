package net.liccioni.archetypes.money.payment;

import lombok.Builder;

@Builder(toBuilder = true)
public record Cash() implements PaymentMethod {

}
