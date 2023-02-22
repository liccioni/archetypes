package net.liccioni.archetypes.product.productpackage;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.product.ProductInstance;

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PackageInstance extends ProductInstance {

    @Builder.Default
    Set<ProductInstance> components = new HashSet<>();
}
