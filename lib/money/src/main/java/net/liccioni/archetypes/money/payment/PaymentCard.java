package net.liccioni.archetypes.money.payment;

import net.liccioni.archetypes.common.TimeDate;

public interface PaymentCard extends PaymentMethod {
    String cardAssociationName();

    String cardNumber();

    String nameOnCard();

    TimeDate expiryDate();

    String billingAddress();

    TimeDate validFrom();

    String cardVerificationCode();

    String issueNumber();
}
