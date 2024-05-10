package net.liccioni.archetypes.money.payment;

import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.Money;

public interface Payment extends Money {

    TimeDate dateMade();

    TimeDate dateReceived();

    TimeDate dateDue();

    TimeDate dateCreated();

    PaymentMethod paymentMethod();
}
