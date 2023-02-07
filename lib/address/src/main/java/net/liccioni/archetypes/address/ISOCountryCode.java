package net.liccioni.archetypes.address;


import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class ISOCountryCode extends Locale {

    String alphabeticThreeCharCode;
    String numericCode;
    String officialName;

    public String getShortName() {

        return this.getName();
    }

    public String getAlphabeticTwoCharCode() {

        return this.getIdentifier();
    }
}
