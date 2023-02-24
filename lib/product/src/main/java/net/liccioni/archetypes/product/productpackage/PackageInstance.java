package net.liccioni.archetypes.product.productpackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.product.ProductInstance;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class PackageInstance extends ProductInstance {

    @Builder.Default
    List<ProductInstance> components = new ArrayList<>();
}
