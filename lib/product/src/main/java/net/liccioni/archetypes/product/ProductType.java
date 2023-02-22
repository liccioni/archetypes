package net.liccioni.archetypes.product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.product.price.Price;
import net.liccioni.archetypes.rule.RuleContext;

@Data
@SuperBuilder(toBuilder = true)
public class ProductType {


    private ProductIdentifier productIdentifier;
    private String name;
    private String description;
    @Builder.Default
    private Set<ProductFeatureType> mandatoryFeatureTypes = new HashSet<>();
    @Builder.Default
    private Set<ProductFeatureType> optionalFeatureTypes = new HashSet<>();
    @Builder.Default
    private Set<Price> prices = new HashSet<>();

    public List<Price> getPrices(RuleContext context) {
        //TODO
        return null;
    }

    public List<Price> getPrices(TimeDate validFrom, TimeDate validTo) {
        //TODO
        return null;
    }
}
