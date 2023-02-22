package net.liccioni.archetypes.product.productpackage;


import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public class PropositionOfInclusion {

    private String name;
    private ProductSet productSet;
    private int minimum;
    private int maximum;
    private PackageInstance targetPackage;

    public boolean isSubSetOf(PackageInstance packageInstance) {
        //TODO
        return false;
    }
}
