package net.liccioni.archetypes.order.event.amendment;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.order.Order;

@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class AmendTermsAndConditionsEvent extends AmendEvent {

    private String oldTermAndConditions;
    private final String newTermAndConditions;

    @Override
    protected void internalProcess(final Order order) {
        oldTermAndConditions = order.getTermsAndCondition();
        order.setTermsAndCondition(newTermAndConditions);
    }
}
