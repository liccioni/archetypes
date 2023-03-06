package net.liccioni.archetypes.order;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.Money;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.product.SerialNumber;

@Data
@Builder(toBuilder = true)
public class OrderLine {

    private final OrderLineIdentifier orderLineIdentifier;
    private final ProductType productType;
    private final SerialNumber serialNumber;
    private final String description;
    private final String comment;
    private final Integer numberOrdered;
    private final Money unitPrice;
    private final TimeDate expectedDeliveryDate;
    @Builder.Default
    private final Set<ChargeLine> chargeLines = new HashSet<>();
    @Builder.Default
    private final Set<TaxOnLine> taxes = new HashSet<>();
    private DeliveryReceiver orderLineReceiver;
}
