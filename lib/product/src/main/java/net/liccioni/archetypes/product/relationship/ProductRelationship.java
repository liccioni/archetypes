package net.liccioni.archetypes.product.relationship;

import net.liccioni.archetypes.product.ProductType;

public interface ProductRelationship {

    ProductType supplier();

    ProductType client();
}
