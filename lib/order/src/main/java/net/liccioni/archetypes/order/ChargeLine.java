package net.liccioni.archetypes.order;


import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.money.Money;

@Value
@Builder(toBuilder = true)
public class ChargeLine {

    Money amount;
    String description;
    String comment;
    TaxOnLine taxOnLine;
}
