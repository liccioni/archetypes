package net.liccioni.archetypes.order.event;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderIdentifier;
import net.liccioni.archetypes.party.PartySignature;

@Data
@SuperBuilder(toBuilder = true)
public abstract class OrderEvent {

    private OrderIdentifier orderIdentifier;
    private final PartySignature authorization;
    private final TimeDate dateAuthorized;
    @Builder.Default
    private Boolean processed = false;

    public void process(final Order order) {
        this.orderIdentifier = order.getOrderIdentifier();
        internalProcess(order);
        order.getAuditTrail().add(this);
        this.processed = true;
    }

    protected abstract void internalProcess(final Order order);
}
