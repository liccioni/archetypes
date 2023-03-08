package net.liccioni.archetypes.order.event;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.order.Order;
import net.liccioni.archetypes.order.OrderIdentifier;
import net.liccioni.archetypes.order.OrderStatus;
import net.liccioni.archetypes.party.PartySignature;

@Data
@SuperBuilder(toBuilder = true)
public abstract class OrderEvent {

    @NonNull
    private OrderIdentifier orderIdentifier;
    private final PartySignature authorization;
    private final TimeDate dateAuthorized;
    @Builder.Default
    private Boolean processed = false;

    public void process(final Order order) {
        this.orderIdentifier = order.getOrderIdentifier();
        order.getStatus().handle(order, this);
        order.getAuditTrail().add(this);
        this.processed = true;
    }

    public abstract void process(final OrderStatus orderStatus, final Order order);
}
