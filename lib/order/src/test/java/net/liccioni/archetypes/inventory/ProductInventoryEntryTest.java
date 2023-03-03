package net.liccioni.archetypes.inventory;

import static org.assertj.core.api.Assertions.assertThat;

import net.liccioni.archetypes.product.ProductIdentifier;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.rule.RuleContext;
import org.junit.jupiter.api.Test;

class ProductInventoryEntryTest {

    private final ProductType p1 = ProductType.builder()
            .productIdentifier(ProductIdentifier.builder().id("p1").build())
            .name("p1").build();

    @Test
    void shouldRestock() {
        final ProductInventoryEntry inventoryEntry = ProductInventoryEntry.builder()
                .productType(p1)
                .build();
        assertThat(inventoryEntry.restock(RuleContext.builder().build())).isTrue();
    }
}