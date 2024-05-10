package net.liccioni.archetypes.money;


import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.address.Locale;
import net.liccioni.archetypes.common.TimeDate;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record ISOCurrency(String name,
                          String definition,
                          @NonNull String alphabeticCode,
                          String numericCode,
                          String majorUnitSymbol,
                          String minorUnitSymbol,
                          Double ratioOfMinorToMajorUnit,
                          TimeDate introductionDate,
                          TimeDate expirationDate,
                          Set<Locale> acceptedIn
) implements Currency {

    @Builder(toBuilder = true)
    public ISOCurrency(String name,
                       String definition,
                       @NonNull String alphabeticCode,
                       String numericCode,
                       String majorUnitSymbol,
                       String minorUnitSymbol,
                       Double ratioOfMinorToMajorUnit,
                       TimeDate introductionDate,
                       TimeDate expirationDate,
                       Set<Locale> acceptedIn) {
        this.name = name;
        this.definition = definition;
        this.alphabeticCode = alphabeticCode;
        this.numericCode = numericCode;
        this.majorUnitSymbol = majorUnitSymbol;
        this.minorUnitSymbol = minorUnitSymbol;
        this.ratioOfMinorToMajorUnit = ratioOfMinorToMajorUnit;
        this.introductionDate = introductionDate;
        this.expirationDate = expirationDate;
        this.acceptedIn = Optional.ofNullable(acceptedIn).orElseGet(HashSet::new);
    }

    @Override
    public String symbol() {
        return this.alphabeticCode;
    }
}
