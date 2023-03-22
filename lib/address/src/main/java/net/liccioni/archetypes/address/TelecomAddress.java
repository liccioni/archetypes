package net.liccioni.archetypes.address;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class TelecomAddress extends Address {

    String countryCode;
    String nationalDirectDialingPrefix;
    String areaCode;
    String number;
    String extension;
    String physicalType;
    Locale locale;

    @Override
    public String getAddress() {
        return String.format("+%s (%s) %s %s ext. %s",
                countryCode, nationalDirectDialingPrefix, areaCode, number, extension);
    }
}
