package net.liccioni.archetypes.order;


import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class SalesTaxPolicy {

    String taxationType;
    Double taxationRate;
}
