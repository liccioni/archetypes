package net.liccioni.archetypes.product.productpackage;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;
import net.liccioni.archetypes.product.ProductIdentifier;
import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.product.ProductType;
import org.junit.jupiter.api.Test;

class PropositionOfInclusionTest {

    @Test
    void shouldEvaluateSubset() {

        ProductType starter1 = ProductType.builder().productIdentifier(ProductIdentifier.builder().id("1").build())
                .name("Petite assiette de crudités").build();
        ProductType starter2 = ProductType.builder().productIdentifier(ProductIdentifier.builder().id("2").build())
                .name("Potage du chef").build();
        ProductType starter3 = ProductType.builder().productIdentifier(ProductIdentifier.builder().id("3").build())
                .name("Calamars marinés aux feuilles de citron").build();
        ProductType starter4 = ProductType.builder().productIdentifier(ProductIdentifier.builder().id("3").build())
                .name("Salade de chèvre chaud").build();

        final var starters = ProductSet.builder().name("Starters set")
                .productIdentifier(Stream.of(starter1, starter2, starter3, starter4)
                        .map(ProductType::getProductIdentifier).collect(toSet()))
                .build();
        final var startersRule =
                PropositionOfInclusion.builder().name("Starters").minimum(1).maximum(1).productSet(starters).build();

        final var oneStartersPackage = buildInstanceSet(starter1);
        final var shouldResultTrue = startersRule.isSubSetOf(oneStartersPackage);
        assertThat(shouldResultTrue).isTrue();

        final var twoStartersPackage = buildInstanceSet(starter1,starter2);
        final var shouldResultFalse = startersRule.isSubSetOf(twoStartersPackage);
        assertThat(shouldResultFalse).isFalse();
    }

    private PackageInstance buildInstanceSet(ProductType... types) {
        final Set<ProductInstance> components =
                Arrays.stream(types).map(p -> ProductInstance.builder().productType(p).build())
                        .collect(toSet());
        return PackageInstance.builder().components(components).build();
    }
}