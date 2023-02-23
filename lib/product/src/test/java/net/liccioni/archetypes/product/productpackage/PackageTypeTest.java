package net.liccioni.archetypes.product.productpackage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.liccioni.archetypes.product.ProductIdentifier;
import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.product.ProductType;
import org.junit.jupiter.api.Test;

class PackageTypeTest {

    private final AtomicInteger productId = new AtomicInteger(0);

    private final List<ProductType> starters = Stream.of(
            "Petite assiette de crudités",
            "Potage du chef",
            "Calamars marinés aux feuilles de citron",
            "Salade de chèvre chaud").map(this::createProduct).collect(Collectors.toList());

    private final List<ProductType> mains = Stream.of(
            "Plat du jour",
            "Fricassée de suprême de poulet",
            "Médaillons de veau aux graines de sésame",
            "Côtes d'agneau braisées aux amandes").map(this::createProduct).collect(Collectors.toList());

    private final List<ProductType> desserts = Stream.of(
            "Sélection de fromages fins",
            "Tarte aux fraises",
            "Crème brulé à la vanille",
            "Assortiment du chariot de desserts").map(this::createProduct).collect(Collectors.toList());

    private final ProductSet startersSet = createProductSet("starters", starters);
    private final PropositionOfInclusion poiStarters = PropositionOfInclusion.builder()
            .name("starters")
            .minimum(1)
            .maximum(1)
            .productSet(startersSet)
            .build();

    private final ProductSet mainsSet = createProductSet("mains", mains);
    private final PropositionOfInclusion poiMains = PropositionOfInclusion.builder()
            .name("mains")
            .minimum(1)
            .maximum(1)
            .productSet(mainsSet)
            .build();

    private final ProductSet dessertsSet = createProductSet("desserts", desserts);
    private final PropositionOfInclusion poiDesserts = PropositionOfInclusion.builder()
            .name("desserts")
            .minimum(1)
            .maximum(1)
            .productSet(dessertsSet)
            .build();

    private final PackageType menu = PackageType.builder().name("French Menu")
            .propositionOfInclusion(Set.of(poiStarters, poiMains, poiDesserts))
            .build();

    @Test
    void shouldValidate() {

        final var components = new HashSet<>();
        starters.stream().map(ProductType::getProductIdentifier).forEach(components::add);
        mains.stream().map(ProductType::getProductIdentifier).forEach(components::add);
        desserts.stream().map(ProductType::getProductIdentifier).forEach(components::add);
        assertThat(menu.getComponents()).containsExactlyInAnyOrder(components.toArray(ProductIdentifier[]::new));

        final var pSets = new HashSet<>();
        pSets.add(startersSet);
        pSets.add(mainsSet);
        pSets.add(dessertsSet);
        assertThat(menu.getProductSet()).containsExactlyInAnyOrder(pSets.toArray(ProductSet[]::new));

        final var validInstance = PackageInstance.builder()
                .productType(menu)
                .components(Stream.of(starters.get(0), mains.get(2), desserts.get(3))
                        .map(p -> ProductInstance.builder().productType(p).build())
                        .collect(Collectors.toSet()))
                .build();

        assertThat(menu.validate(validInstance)).isTrue();

        final var inValidInstance = PackageInstance.builder()
                .productType(menu)
                .components(Stream.of(starters.get(0), mains.get(2), desserts.get(3), desserts.get(0))
                        .map(p -> ProductInstance.builder().productType(p).build())
                        .collect(Collectors.toSet()))
                .build();

        assertThat(menu.validate(inValidInstance)).isFalse();
    }

    @Test
    void shouldValidateIsSelectionOf() {
        PropositionOfInclusion secondStarterOptional = PropositionOfInclusion.builder()
                .name("secondStarterOptional")
                .minimum(0)
                .maximum(1)
                .productSet(startersSet)
                .build();
        PackageType menu2StartersOptional = PackageType.builder().name("French Menu")
                .propositionOfInclusion(Set.of(poiStarters, secondStarterOptional, poiMains, poiDesserts))
                .build();

        final var validInstance = PackageInstance.builder()
                .productType(menu2StartersOptional)
                .components(Stream.of(starters.get(0), mains.get(2), desserts.get(3))
                        .map(p -> ProductInstance.builder().productType(p).build())
                        .collect(Collectors.toSet()))
                .build();

        assertThat(menu2StartersOptional.validate(validInstance)).isTrue();

        final var validInstanceSecondStarter = PackageInstance.builder()
                .productType(menu2StartersOptional)
                .components(Stream.of(starters.get(0), starters.get(1), mains.get(2), desserts.get(3))
                        .map(p -> ProductInstance.builder().productType(p).build())
                        .collect(Collectors.toSet()))
                .build();

        assertThat(menu2StartersOptional.validate(validInstanceSecondStarter)).isTrue();
    }

    private ProductSet createProductSet(final String name, final List<ProductType> products) {
        return ProductSet.builder()
                .name(name)
                .products(products.stream().map(ProductType::getProductIdentifier).collect(Collectors.toSet()))
                .build();
    }

    private ProductType createProduct(String name) {
        final ProductIdentifier id =
                ProductIdentifier.builder().id(Integer.toString(productId.incrementAndGet())).build();
        return ProductType.builder()
                .productIdentifier(id)
                .name(name)
                .build();
    }
}