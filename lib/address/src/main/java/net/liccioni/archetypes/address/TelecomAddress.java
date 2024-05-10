package net.liccioni.archetypes.address;

import lombok.Builder;

@Builder(toBuilder = true)
public record TelecomAddress(String countryCode,
                             String nationalDirectDialingPrefix,
                             String areaCode,
                             String number,
                             String extension,
                             String physicalType,
                             Locale locale) implements Address {

    @Override
    public String address() {
        return String.format("+%s (%s) %s %s ext. %s",
                countryCode, nationalDirectDialingPrefix, areaCode, number, extension);
    }
}
