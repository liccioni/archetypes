package net.liccioni.archetypes.address;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public abstract class Address {

    public abstract String getAddress();
}
