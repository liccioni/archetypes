package net.liccioni.archetypes.order;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.Money;
import net.liccioni.archetypes.product.ProductType;
import net.liccioni.archetypes.product.SerialNumber;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record OrderLine(OrderLineIdentifier orderLineIdentifier,
                        ProductType productType,
                        SerialNumber serialNumber,
                        String description,
                        String comment,
                        Integer numberOrdered,
                        Money unitPrice,
                        TimeDate expectedDeliveryDate,
                        Set<ChargeLine> chargeLines,
                        Set<TaxOnLine> taxes,
                        DeliveryReceiver orderLineReceiver) {
    @Builder(toBuilder = true)
    public OrderLine(@NonNull OrderLineIdentifier orderLineIdentifier,
                     ProductType productType,
                     SerialNumber serialNumber,
                     String description,
                     String comment,
                     Integer numberOrdered,
                     Money unitPrice,
                     TimeDate expectedDeliveryDate,
                     Set<ChargeLine> chargeLines,
                     Set<TaxOnLine> taxes,
                     DeliveryReceiver orderLineReceiver) {
        this.orderLineIdentifier = orderLineIdentifier;
        this.productType = productType;
        this.serialNumber = serialNumber;
        this.description = description;
        this.comment = comment;
        this.numberOrdered = numberOrdered;
        this.unitPrice = unitPrice;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.chargeLines = Optional.ofNullable(chargeLines).orElseGet(HashSet::new);
        this.taxes = Optional.ofNullable(taxes).orElseGet(HashSet::new);
        this.orderLineReceiver = orderLineReceiver;
    }
}
