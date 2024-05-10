package net.liccioni.archetypes.order;


import lombok.Builder;
import net.liccioni.archetypes.money.Money;

@Builder(toBuilder = true)
public record ChargeLine(Money amount,
                         String description,
                         String comment,
                         TaxOnLine taxOnLine) {
}
