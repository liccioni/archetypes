package net.liccioni.archetypes.product;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class ProductFeatureType {

    String name;
    String description;
    @Builder.Default
    Set<ProductFeatureInstance> possibleValues = new HashSet<>();
}
