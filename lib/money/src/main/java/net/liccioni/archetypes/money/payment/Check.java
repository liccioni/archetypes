package net.liccioni.archetypes.money.payment;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class Check extends PaymentMethod {
    String accountName;
    String accountNumber;
    String checkNumber;
    String payee;
    TimeDate dateWritten;
    String bankName;
    String bankAddress;
    String bankIdentificationNumber;
}
