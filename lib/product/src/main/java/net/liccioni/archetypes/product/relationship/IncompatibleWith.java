package net.liccioni.archetypes.product.relationship;


import lombok.Builder;
import net.liccioni.archetypes.product.ProductType;

@Builder(toBuilder = true)
public record IncompatibleWith(ProductType supplier, ProductType client) implements ProductRelationship {
}
