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
public abstract class Order {


    private final OrderIdentifier orderIdentifier;
    @Builder.Default
    private OrderStatus status = OrderStatus.INITIALIZING;
    private final TimeDate dateCreated;
    private final String salesChannel;
    private final String termsAndCondition;
    @Builder.Default
    private final Set<OrderLine> lineItems = new HashSet<>();
    @Builder.Default
    private final Set<ChargeLine> chargeLines = new HashSet<>();
    @Builder.Default
    private final List<OrderEvent> auditTrail = new ArrayList<>();
    private final PartySummary orderInitiator;
    private final PartySummary purchaser;
    private final PartySummary salesAgent;
    private final PartySummary paymentReceiver;
    private final PartySummary vendor;
    private final DeliveryReceiver orderReceiver;
    private final RuleContext discountContext;

    public void acceptEvent(OrderEvent orderEvent) {
        orderEvent.process(this);
    }

    public boolean processDiscountEvent() {
        //TODO
        return false;
    }

    public boolean processLifeCycleEvent() {
        //TODO
        return false;
    }

    public boolean processAmendEvent() {
        //TODO
        return false;
    }

    public abstract void processInvoiceEvent();

    public void addPartySummary(PartySummary reference, PartySummaryRoleInOrder role) {

    }

    public void close() {
        status.close(this);
    }

    public void open() {
        status.open(this);
    }

    public void cancel() {
        status.cancel(this);
    }
}
