package net.liccioni.archetypes.product.productpackage;


import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.product.ProductType;

import java.util.Collections;
import java.util.Optional;

public interface PropositionOfInclusion {

    String name();

    ProductSet productSet();

    int minimum();

    int maximum();

    default boolean isSubSetOf(PackageInstance targetPackage) {
        final long count = Optional.ofNullable(targetPackage)
                .map(PackageInstance::components)
                .orElseGet(Collections::emptyList)
                .stream().map(ProductInstance::productType)
                .map(ProductType::productIdentifier)
                .filter(productSet()::contains).count();
        return count >= minimum() && count <= maximum();
    }
}
