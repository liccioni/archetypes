package net.liccioni.archetypes.address;

import lombok.Builder;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Builder(toBuilder = true)
public record GeographicAddress(List<String> addressLine,
                                String city,
                                String regionOrState,
                                String zipOrPostCode,
                                @NonNull Locale country) implements Address {

    public static class GeographicAddressBuilder {
        private List<String> addressLine = new ArrayList<>();
        private String city = "";
        private String regionOrState = "";
        private String zipOrPostCode = "";
    }

    @Override
    public String address() {
        return String.format("%s, %s, %s, %s, %s",
                String.join(",", addressLine), city, regionOrState, zipOrPostCode, country.name());
    }
}
