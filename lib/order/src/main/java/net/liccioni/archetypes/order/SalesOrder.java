package net.liccioni.archetypes.order;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class SalesOrder extends Order {

    TimeDate datePurchaseOrderReceived;
    String customerOrderPurchaseReference;

    public boolean processDespatchEvent() {
        //TODO
        return false;
    }

    public void processInvoiceEvent() {
    }

    public boolean processAcceptPaymentEvent() {
        //TODO
        return false;
    }

    public boolean processMakeRefundEvent() {
        //TODO
        return false;
    }
}
