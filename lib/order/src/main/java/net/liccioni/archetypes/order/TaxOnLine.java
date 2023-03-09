package net.liccioni.archetypes.order;


import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class TaxOnLine {

    String taxationType;
    Double taxationRate;
    String comment;
}
