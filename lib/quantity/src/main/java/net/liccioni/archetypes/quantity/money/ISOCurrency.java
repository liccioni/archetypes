package net.liccioni.archetypes.quantity.money;


import java.util.Set;
import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.address.Locale;
import net.liccioni.archetypes.common.TimeDate;

@Value
@Builder
public class ISOCurrency implements Currency {

    String name;
    String definition;
    String alphabeticCode;
    String numericCode;
    String majorUnitSymbol;
    String minorUnitSymbol;
    Double ratioOfMinorToMajorUnit;
    TimeDate introductionDate;
    TimeDate expirationDate;
    Set<Locale> acceptedIn;

    @Override
    public String getSymbol() {
        return this.alphabeticCode;
    }
}
