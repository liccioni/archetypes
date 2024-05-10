package net.liccioni.archetypes.order;

import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.event.OrderEvent;
import net.liccioni.archetypes.order.event.amendment.AmendPartySummaryEvent;
import net.liccioni.archetypes.rule.RuleContext;

import java.util.List;
import java.util.Set;

public interface Order {
    OrderIdentifier orderIdentifier();

    OrderStatus status();

    TimeDate dateCreated();

    String salesChannel();

    String termsAndCondition();

    Set<OrderLine> lineItems();

    Set<ChargeLine> chargeLines();

    List<OrderEvent> auditTrail();

    PartySummary orderInitiator();

    PartySummary purchaser();

    PartySummary salesAgent();

    PartySummary paymentReceiver();

    PartySummary vendor();

    DeliveryReceiver orderReceiver();

    RuleContext discountContext();

    default Order acceptEvent(OrderEvent orderEvent) {
        return orderEvent.process(this);
    }

    Order setStatus(OrderStatus orderStatus);

    Order setTermsAndCondition(String newTermAndConditions);

    Order setSalesAgent(PartySummary partySummary);
}
