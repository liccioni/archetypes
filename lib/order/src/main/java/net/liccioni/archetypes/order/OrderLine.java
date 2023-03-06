package net.liccioni.archetypes.order;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.Money;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.product.SerialNumber;

@Value
@Builder(toBuilder = true)
public class OrderLine {

    OrderLineIdentifier orderLineIdentifier;
    ProductType productType;
    SerialNumber serialNumber;
    String description;
    String comment;
    Integer numberOrdered;
    Money unitPrice;
    TimeDate expectedDeliveryDate;
    @Builder.Default
    Set<ChargeLine> chargeLines = new HashSet<>();
    @Builder.Default
    Set<TaxOnLine> taxes = new HashSet<>();
    DeliveryReceiver orderLineReceiver;
}
