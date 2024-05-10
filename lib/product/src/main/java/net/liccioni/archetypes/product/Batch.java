package net.liccioni.archetypes.product;


import lombok.Builder;

@Builder(toBuilder = true)
public record Batch(String batchIdentifier,
                    ProductIdentifier batchOf,
                    int numberInBatch) {
}
