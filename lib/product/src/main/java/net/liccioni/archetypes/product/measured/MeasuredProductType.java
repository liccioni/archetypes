package net.liccioni.archetypes.product.measured;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.quantity.Metric;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class MeasuredProductType extends ProductType {

    Metric preferredMetric;
    @Builder.Default
    Set<Metric> possibleMetrics = new HashSet<>();
}
