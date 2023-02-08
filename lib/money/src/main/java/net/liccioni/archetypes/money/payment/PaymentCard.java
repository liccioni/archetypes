package net.liccioni.archetypes.money.payment;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;

@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public abstract class PaymentCard extends PaymentMethod {
    private final String cardAssociationName;
    private final String cardNumber;
    private final String nameOnCard;
    private final TimeDate expiryDate;
    private final String billingAddress;
    private final TimeDate validFrom;
    private final String cardVerificationCode;
    private final String issueNumber;
}
