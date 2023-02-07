package net.liccioni.archetypes.quantity.money;


import lombok.Getter;
import net.liccioni.archetypes.common.TimeDate;


public class Payment extends Money {

    @Getter
    private final TimeDate dateMade;
    @Getter
    private final TimeDate dateReceived;
    @Getter
    private final TimeDate dateDue;
    @Getter
    private final TimeDate dateCreated;

    public Payment(final Number amount, final Currency currency, final TimeDate dateMade,
                   final TimeDate dateReceived, final TimeDate dateDue,
                   final TimeDate dateCreated) {
        super(amount, currency);
        this.dateMade = dateMade;
        this.dateReceived = dateReceived;
        this.dateDue = dateDue;
        this.dateCreated = dateCreated;
    }
}
