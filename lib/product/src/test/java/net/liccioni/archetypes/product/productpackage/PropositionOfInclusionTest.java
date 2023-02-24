package net.liccioni.archetypes.product.productpackage;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
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
                .products(Stream.of(starter1, starter2, starter3, starter4)
                        .map(ProductType::getProductIdentifier).collect(toSet()))
                .build();
        final var startersRule =
                PropositionOfInclusion.builder().name("Starters").minimum(1).maximum(1).productSet(starters).build();

        ProductType type = PackageType.builder().name("package").build();
        final var oneStartersPackage = buildInstanceSet(type, starter1);
        startersRule.setTargetPackage(oneStartersPackage);
        final var shouldResultTrue = startersRule.isSubSetOf();
        assertThat(shouldResultTrue).isTrue();

        final var twoStartersPackage = buildInstanceSet(type, starter1, starter2);
        startersRule.setTargetPackage(twoStartersPackage);
        final var shouldResultFalse = startersRule.isSubSetOf();
        assertThat(shouldResultFalse).isFalse();
    }

    private PackageInstance buildInstanceSet(final ProductType type,
                                             ProductType... types) {
        final List<ProductInstance> components =
                Arrays.stream(types).map(p -> ProductInstance.builder().productType(p).build())
                        .collect(toList());
        return PackageInstance.builder().productType(type).components(components).build();
    }
}