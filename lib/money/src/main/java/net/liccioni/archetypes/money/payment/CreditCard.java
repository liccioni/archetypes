package net.liccioni.archetypes.money.payment;

import lombok.Builder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.Money;

@Builder(toBuilder = true)
public record CreditCard(String cardAssociationName,
                         String cardNumber,
                         String nameOnCard,
                         TimeDate expiryDate,
                         String billingAddress,
                         TimeDate validFrom,
                         String cardVerificationCode,
                         String issueNumber,
                         Money creditLimit,
                         Money dailyWithdrawalLimit) implements PaymentCard {
}
