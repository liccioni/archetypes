package net.liccioni.archetypes.product.productpackage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import net.liccioni.archetypes.product.ProductIdentifier;
import org.junit.jupiter.api.Test;

class ProductSetTest {

    @Test
    void shouldCompareProductSets() {
        final var productSet1 = ProductSet.builder()
                .name("productSet1").products(getIdSet(1, 2, 3, 4, 5))
                .build();
        final var productSet2 = ProductSet.builder()
                .name("productSet2").products(getIdSet(1, 2, 3, 4, 5))
                .build();

        final var productSet3 = ProductSet.builder()
                .name("productSet3").products(getIdSet(1, 2, 3, 4, 6))
                .build();
        assertThat(productSet1.products()).isEqualTo(productSet2.products());
        assertThat(productSet1.products()).isNotEqualTo(productSet3.products());
    }

    private Set<ProductIdentifier> getIdSet(final int... i) {
        return Arrays.stream(i)
                .mapToObj(p -> ProductIdentifier.builder().id(Integer.toString(p)).build()).collect(Collectors.toSet());
    }
}