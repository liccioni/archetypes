package net.liccioni.archetypes.product;


import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class ProductFeatureInstance {

    String value;
    ProductFeatureType productFeatureType;

    @Builder.Default
    Set<String> possibleValues = new HashSet<>();

    public String getName() {

        return productFeatureType.getName();
    }

    public String getDescription() {

        return productFeatureType.getDescription();
    }
}
