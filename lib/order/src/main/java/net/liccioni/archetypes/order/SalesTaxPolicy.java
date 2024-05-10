package net.liccioni.archetypes.order;

import lombok.Builder;

@Builder(toBuilder = true)
public record SalesTaxPolicy(String taxationType, Double taxationRate) {

}
