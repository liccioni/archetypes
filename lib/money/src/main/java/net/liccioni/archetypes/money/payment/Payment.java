package net.liccioni.archetypes.money.payment;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.Currency;
import net.liccioni.archetypes.money.Money;

@ToString(callSuper = true)
public class Payment extends Money {

    @Getter
    private final TimeDate dateMade;
    @Getter
    private final TimeDate dateReceived;
    @Getter
    private final TimeDate dateDue;
    @Getter
    private final TimeDate dateCreated;
    @Getter
    private final PaymentMethod paymentMethod;

    @Builder(builderMethodName = "paymentBuilder")
    protected Payment(final Number amount,
                      final Currency currency,
                      final TimeDate dateMade,
                      final TimeDate dateReceived,
                      final TimeDate dateDue,
                      final TimeDate dateCreated,
                      final PaymentMethod paymentMethod) {
        super(amount, currency);
        this.dateMade = dateMade;
        this.dateReceived = dateReceived;
        this.dateDue = dateDue;
        this.dateCreated = dateCreated;
        this.paymentMethod = paymentMethod;
    }
}
