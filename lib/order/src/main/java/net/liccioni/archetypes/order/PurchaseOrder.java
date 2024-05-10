package net.liccioni.archetypes.order;

import lombok.Builder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.event.OrderEvent;
import net.liccioni.archetypes.rule.RuleContext;

import java.util.*;

public record PurchaseOrder(OrderIdentifier orderIdentifier,
                            OrderStatus status,
                            TimeDate dateCreated,
                            String salesChannel,
                            String termsAndCondition,
                            Set<OrderLine> lineItems,
                            Set<ChargeLine> chargeLines,
                            List<OrderEvent> auditTrail,
                            PartySummary orderInitiator,
                            PartySummary purchaser,
                            PartySummary salesAgent,
                            PartySummary paymentReceiver,
                            PartySummary vendor,
                            DeliveryReceiver orderReceiver,
                            RuleContext discountContext,
                            TimeDate dateSent) implements Order {

    @Builder(toBuilder = true)
    public PurchaseOrder(OrderIdentifier orderIdentifier,
                         OrderStatus status,
                         TimeDate dateCreated,
                         String salesChannel,
                         String termsAndCondition,
                         Set<OrderLine> lineItems,
                         Set<ChargeLine> chargeLines,
                         List<OrderEvent> auditTrail,
                         PartySummary orderInitiator,
                         PartySummary purchaser,
                         PartySummary salesAgent,
                         PartySummary paymentReceiver,
                         PartySummary vendor,
                         DeliveryReceiver orderReceiver,
                         RuleContext discountContext,
                         TimeDate dateSent) {
        this.orderIdentifier = orderIdentifier;
        this.status = Optional.ofNullable(status).orElse(OrderStatus.INITIALIZING);
        this.dateCreated = dateCreated;
        this.salesChannel = salesChannel;
        this.termsAndCondition = termsAndCondition;
        this.lineItems = Optional.ofNullable(lineItems).orElseGet(HashSet::new);
        this.chargeLines = Optional.ofNullable(chargeLines).orElseGet(HashSet::new);
        this.auditTrail = Optional.ofNullable(auditTrail).orElseGet(ArrayList::new);
        this.orderInitiator = orderInitiator;
        this.purchaser = purchaser;
        this.salesAgent = salesAgent;
        this.paymentReceiver = paymentReceiver;
        this.vendor = vendor;
        this.orderReceiver = orderReceiver;
        this.discountContext = Optional.ofNullable(discountContext).orElseGet(() -> RuleContext.builder().build());
        this.dateSent = dateSent;
    }

    @Override
    public Order setStatus(OrderStatus orderStatus) {
        return this.toBuilder().status(orderStatus).build();
    }

    @Override
    public Order setTermsAndCondition(String newTermAndConditions) {
        return toBuilder().termsAndCondition(newTermAndConditions).build();
    }

    @Override
    public Order setSalesAgent(PartySummary partySummary) {
        return toBuilder().salesAgent(partySummary).build();
    }
}
