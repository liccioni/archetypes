package net.liccioni.archetypes.product.productpackage;


import java.util.Collections;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
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
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.PACKAGE)
    @Getter(AccessLevel.NONE)
    private PackageInstance targetPackage;

    public boolean isSubSetOf() {
        final long count = Optional.ofNullable(targetPackage)
                .map(PackageInstance::getComponents)
                .orElseGet(Collections::emptyList)
                .stream().map(ProductInstance::getProductType)
                .map(ProductType::getProductIdentifier)
                .filter(productSet::contains).count();
        return count >= minimum && count <= maximum;
    }
}
