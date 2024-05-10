package net.liccioni.archetypes.order;

import lombok.Builder;

@Builder(toBuilder = true)
public record TaxOnLine(String taxationType, Double taxationRate, String comment) {

}
