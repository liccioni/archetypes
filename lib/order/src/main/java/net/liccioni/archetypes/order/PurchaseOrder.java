package net.liccioni.archetypes.order;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class PurchaseOrder extends Order {

    TimeDate dateSent;

    public boolean processReceiptEvent() {
        //TODO
        return false;
    }

    public void processInvoiceEvent() {
    }

    public boolean processMakePaymentEvent() {
        //TODO
        return false;
    }

    public boolean processAcceptRefundEvent() {
        //TODO
        return false;
    }
}
