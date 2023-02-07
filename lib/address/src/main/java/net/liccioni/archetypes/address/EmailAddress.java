package net.liccioni.archetypes.address;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class EmailAddress extends Address {

    @NonNull
    String emailAddress;

    @Override
    public String getAddress() {
        return this.emailAddress;
    }
}
