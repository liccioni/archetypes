package net.liccioni.archetypes.product;


import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Batch {

    String batchIdentifier;
    ProductIdentifier batchOf;
    int numberInBatch;
}
