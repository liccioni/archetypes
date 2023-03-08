package net.liccioni.archetypes.order;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.event.OrderEvent;
import net.liccioni.archetypes.rule.RuleContext;

@Data
@SuperBuilder(toBuilder = true)
public class Order {

    private final OrderIdentifier orderIdentifier;
    @Builder.Default
    private OrderStatus status = OrderStatus.INITIALIZING;
    private final TimeDate dateCreated;
    private final String salesChannel;
    private String termsAndCondition;
    @Builder.Default
    private final Set<OrderLine> lineItems = new HashSet<>();
    @Builder.Default
    private final Set<ChargeLine> chargeLines = new HashSet<>();
    @Builder.Default
    private final List<OrderEvent> auditTrail = new ArrayList<>();
    private PartySummary orderInitiator;
    private PartySummary purchaser;
    private PartySummary salesAgent;
    private PartySummary paymentReceiver;
    private PartySummary vendor;
    private DeliveryReceiver orderReceiver;
    @Builder.Default
    private final RuleContext discountContext = RuleContext.builder().build();

    public void acceptEvent(OrderEvent orderEvent) {
        orderEvent.process(this);
    }

    public boolean processDiscountEvent() {
        //TODO
        return false;
    }

    public void processInvoiceEvent() {

    }
}
