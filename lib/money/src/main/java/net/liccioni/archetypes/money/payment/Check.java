package net.liccioni.archetypes.money.payment;

import lombok.Builder;
import net.liccioni.archetypes.common.TimeDate;

@Builder(toBuilder = true)
public record Check(String accountName,
                    String accountNumber,
                    String checkNumber,
                    String payee,
                    TimeDate dateWritten,
                    String bankName,
                    String bankAddress,
                    String bankIdentificationNumber) implements PaymentMethod {
}
