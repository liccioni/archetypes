package net.liccioni.archetypes.address;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class GeographicAddress extends Address {


    @Builder.Default
    Set<String> addressLine = new HashSet<>();
    @Builder.Default
    String city = "";
    @Builder.Default
    String regionOrState = "";
    @Builder.Default
    String zipOrPostCode = "";
    @NonNull
    Locale country;

    @Override
    public String getAddress() {
        return String.format("%s, %s, %s, %s, %s",
                String.join(",", addressLine), city, regionOrState, zipOrPostCode, country.getName());
    }
}
