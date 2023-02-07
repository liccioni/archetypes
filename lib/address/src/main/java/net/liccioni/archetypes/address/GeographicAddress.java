package net.liccioni.archetypes.address;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class GeographicAddress extends Address {


    @Builder.Default
    Set<String> addressLine = new HashSet<>();
    String city;
    String regionOrState;
    String zipOrPostCode;

    @Override
    public String getAddress() {
        return this.toString();
    }
}
