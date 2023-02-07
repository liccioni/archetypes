package net.liccioni.archetypes.address;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class WebPageAddress extends Address {

    String url;

    @Override
    public String getAddress() {
        return this.url;
    }
}
