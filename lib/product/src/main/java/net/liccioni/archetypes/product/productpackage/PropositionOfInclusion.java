package net.liccioni.archetypes.product.productpackage;


import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.product.ProductType;

@Data
@SuperBuilder(toBuilder = true)
public class PropositionOfInclusion {

    private final String name;
    private final ProductSet productSet;
    private final int minimum;
    private final int maximum;

    public boolean isSubSetOf(PackageInstance targetPackage) {
        final var count = targetPackage.getComponents().stream()
                .map(ProductInstance::getProductType)
                .map(ProductType::getProductIdentifier)
                .filter(productSet::contains).count();
        return count >= minimum && count <= maximum;
    }
}
