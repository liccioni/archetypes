package net.liccioni.archetypes.address;


import lombok.Builder;
import lombok.NonNull;

@Builder(toBuilder = true)
public record ISOCountryCode(@NonNull String identifier,
                             @NonNull String name,
                             String description,
                             String alphabeticThreeCharCode,
                             String numericCode,
                             String officialName) implements Locale {

    public String getShortName() {

        return this.name;
    }

    public String getAlphabeticTwoCharCode() {

        return this.identifier;
    }
}
