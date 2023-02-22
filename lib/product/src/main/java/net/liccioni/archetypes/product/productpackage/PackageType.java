package net.liccioni.archetypes.product.productpackage;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.product.ProductType;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class PackageType extends ProductType {

    @Builder.Default
    Set<ProductSet> productSet = new HashSet<>();
    @Builder.Default
    Set<ProductType> components = new HashSet<>();
    @Builder.Default
    Set<PropositionOfInclusion> propositionOfInclusion = new HashSet<>();

    public boolean addProductType(ProductType productType) {
        //TODO
        return false;
    }

    public boolean addProductSet(ProductSet set) {
        //TODO
        return false;
    }


    /**
     * @generated
     */
    public boolean addPropositionOfInclusion(PropositionOfInclusion propositionOfInclusion) {
        //TODO
        return false;
    }


    /**
     * @generated
     */
    public boolean validate(PackageInstance packageInstance) {
        //TODO
        return false;
    }


}
