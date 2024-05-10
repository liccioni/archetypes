package net.liccioni.archetypes.product.productpackage;


import lombok.Builder;

public record PropositionOfInclusionRecord(String name,
                                           ProductSet productSet,
                                           int minimum,
                                           int maximum
) implements PropositionOfInclusion {

    @Builder(toBuilder = true)
    public PropositionOfInclusionRecord(String name,
                                        ProductSet productSet,
                                        int minimum,
                                        int maximum) {
        this.name = name;
        this.productSet = productSet;
        this.minimum = minimum;
        this.maximum = maximum;
    }
}
