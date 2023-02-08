package net.liccioni.archetypes.money.payment;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.money.Money;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class CreditCard extends PaymentCard {
    Money creditLimit;
    Money dailyWithdrawalLimit;
}
