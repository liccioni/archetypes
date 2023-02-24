package net.liccioni.archetypes.product.productpackage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import net.liccioni.archetypes.product.ProductIdentifier;
import net.liccioni.archetypes.product.ProductInstance;
import net.liccioni.archetypes.product.ProductType;
import org.junit.jupiter.api.Test;

class ConditionalPropositionOfInclusionTest {

    private final AtomicInteger productId = new AtomicInteger(0);
    private final Map<String, ProductType> products = new HashMap<>();

    @Test
    void shouldValidateConditionals() {

        final var standardFeatures = createProductSet("standardFeatures",
                List.of("2GHzPentium", "Floppy", "MiniTowerChassis", "Keyboard", "Mouse"));

        final var winMEMemory = createProductSet("winMEMemory",
                List.of("256 MB", "384 MB", "512 MB"));

        final var winOtherMemory = createProductSet("winOtherMemory",
                List.of("256 MB", "384 MB", "512 MB", "768 MB", "1024 MB", "2048 MB"));

        final var hardDrive =
                createProductSet("hardDrive", List.of("40 GB", "40 GBTurbo", "60 GBTurbo", "80 GB", "120 GB"));
        final var monitor = createProductSet("monitor", List.of("Standard17", "Professional17", "Standard19",
                "Professional19", "Professional21", "LCD15", "LCD17", "LCD19"));

        final var videoCard = createProductSet("videoCard", List.of("GeForceMX", "GeForceTi200", "GeForceTi500"));
        final var device1 = createProductSet("device1", List.of("DVD", "ComboDrive"));
        final var combo = createProductSet("combo", List.of("ComboDrive"));
        final var zip = createProductSet("Zip", List.of("Zip"));
        final var dvd = createProductSet("DVD", List.of("DVD"));
        final var cdrw = createProductSet("CDRW", List.of("CDRW"));
        final var soundCard = createProductSet("soundCard", List.of("SBLive"));
        final var speakers = createProductSet("speakers", List.of("Stereo"));

        final var win = createProductSet("win", List.of("WinME", "WinXP", "WinXPPro", "Win2000"));
        final var winME = createProductSet("winME", List.of("WinME"));
        final var winOther = createProductSet("winME", List.of("WinXP", "WinXPPro", "Win2000"));

        final var includeAllStandardFeatures = PropositionOfInclusion.builder().name("IncludeAllStandardFeatures")
                .productSet(standardFeatures)
                .minimum(5)
                .maximum(5)
                .build();
        final var includeOneHardDrive = PropositionOfInclusion.builder().name("IncludeOneHardDrive")
                .productSet(hardDrive)
                .minimum(1)
                .maximum(1)
                .build();
        final var includeOneMonitor = PropositionOfInclusion.builder().name("IncludeOneMonitor")
                .productSet(monitor)
                .minimum(1)
                .maximum(1)
                .build();

        final var includeOneVideoCard = PropositionOfInclusion.builder().name("IncludeOneVideoCard")
                .productSet(videoCard)
                .minimum(1)
                .maximum(1)
                .build();

        final var includeDVDOrComboDrive = PropositionOfInclusion.builder().name("IncludeDVDOrComboDrive")
                .productSet(device1)
                .minimum(1)
                .maximum(1)
                .build();

        final var includeSoundCard = PropositionOfInclusion.builder().name("IncludeSoundCard")
                .productSet(soundCard)
                .minimum(1)
                .maximum(1)
                .build();

        final var includeSpeakers = PropositionOfInclusion.builder().name("IncludeSpeakers")
                .productSet(speakers)
                .minimum(1)
                .maximum(1)
                .build();

        final var includeWindowsOS = PropositionOfInclusion.builder().name("IncludeWindowsOS")
                .productSet(win)
                .minimum(1)
                .maximum(1)
                .build();
        final var ifOSIsWinME = ConditionalPropositionOfInclusion.builder()
                .name("IfOSIsWinME")
                .condition(PropositionOfInclusion.builder().name("IfOSIsWinME").minimum(1).maximum(1)
                        .productSet(winME).build())
                .body(Set.of(PropositionOfInclusion.builder().name("IncludeWinMEMemory")
                        .productSet(winMEMemory)
                        .minimum(1)
                        .maximum(1)
                        .build()))
                .build();

        final var ifOSIsNotWinME = ConditionalPropositionOfInclusion.builder()
                .name("IfOSIsNotWinME")
                .condition(PropositionOfInclusion.builder().name("IfOSIsNotWinME").minimum(1).maximum(1)
                        .productSet(winOther).build())
                .body(Set.of(PropositionOfInclusion.builder().name("IncludeWinMEMemory")
                        .productSet(winOtherMemory)
                        .minimum(1)
                        .maximum(1)
                        .build()))
                .build();

        final var ifComboDrive = ConditionalPropositionOfInclusion.builder()
                .name("IfComboDrive")
                .condition(PropositionOfInclusion.builder().name("IfComboDrive").minimum(1).maximum(1)
                        .productSet(combo).build())
                .body(Set.of(PropositionOfInclusion.builder().name("IncludeZip1")
                        .productSet(zip)
                        .minimum(0)
                        .maximum(1)
                        .build()))
                .build();

        final var ifDVDDrive = ConditionalPropositionOfInclusion.builder()
                .name("IfDVDDrive")
                .condition(PropositionOfInclusion.builder().name("IfDVDDrive").minimum(1).maximum(1)
                        .productSet(dvd).build())
                .body(Set.of(PropositionOfInclusion.builder().name("IncludeCDRW")
                        .productSet(cdrw)
                        .minimum(0)
                        .maximum(1)
                        .build(), PropositionOfInclusion.builder().name("IncludeZip2")
                        .productSet(zip)
                        .minimum(0)
                        .maximum(1)
                        .build()))
                .build();


        final var ruleForPc = PackageType.builder().name("Rule for PC")
                .propositionOfInclusion(Set.of(
                        includeAllStandardFeatures,
                        includeOneHardDrive,
                        includeOneMonitor,
                        includeOneVideoCard,
                        includeDVDOrComboDrive,
                        includeSoundCard,
                        includeSpeakers,
                        includeWindowsOS,
                        ifOSIsWinME,
                        ifOSIsNotWinME,
                        ifComboDrive,
                        ifDVDDrive
                ))
                .build();

        assertThat(ruleForPc.validate(PackageInstance.builder().productType(ruleForPc)
                .components(createProductInstances(
                        "2GHzPentium", "Floppy", "MiniTowerChassis", "Keyboard", "Mouse",
                        "40 GBTurbo", "Professional17", "GeForceTi500", "DVD", "SBLive", "Stereo", "WinME", "384 MB",
                        "Zip"))
                .build())).isTrue();
    }

    private List<ProductInstance> createProductInstances(final String... productNames) {
        return Arrays.stream(productNames)
                .map(products::get)
                .map(p -> ProductInstance.builder()
                        .productType(p)
                        .build())
                .collect(Collectors.toList());
    }

    private ProductSet createProductSet(final String name, final List<String> products) {
        return ProductSet.builder()
                .name(name)
                .products(products.stream().map(this::createProduct)
                        .map(ProductType::getProductIdentifier).collect(Collectors.toSet()))
                .build();
    }

    private ProductType createProduct(String name) {

        return products.computeIfAbsent(name, p ->
                ProductType.builder()
                        .name(name)
                        .productIdentifier(ProductIdentifier.builder()
                                .id(Integer.toString(productId.incrementAndGet())).build())
                        .build());
    }
}