package net.liccioni.archetypes.product.relationship;


import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.product.ProductType;

@Data
@SuperBuilder(toBuilder = true)
public abstract class ProductRelationship {

    private ProductType supplier;
    private ProductType client;
}
