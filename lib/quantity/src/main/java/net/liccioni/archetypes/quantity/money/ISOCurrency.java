package net.liccioni.archetypes.quantity.money;


import java.util.Set;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.address.Locale;

public class ISOCurrency implements Currency {


    private final String name;
    private final String symbol;
    private final String definition;
    private final String alphabeticCode;
    private final String numericCode;
    private final String majorUnitSymbol;
    private final String minorUnitSymbol;
    private final Double ratioOfMinorToMajorUnit;
    private final TimeDate introductionDate;
    private final TimeDate expirationDate;
    private final Set<Locale> acceptedIn;

    public ISOCurrency(final String name,
                       final String symbol,
                       final String definition,
                       final String numericCode,
                       final String majorUnitSymbol,
                       final String minorUnitSymbol,
                       final Double ratioOfMinorToMajorUnit,
                       final TimeDate introductionDate,
                       final TimeDate expirationDate,
                       final Set<Locale> acceptedIn) {
        this.name = name;
        this.symbol = symbol;
        this.definition = definition;
        this.alphabeticCode = symbol;
        this.numericCode = numericCode;
        this.majorUnitSymbol = majorUnitSymbol;
        this.minorUnitSymbol = minorUnitSymbol;
        this.ratioOfMinorToMajorUnit = ratioOfMinorToMajorUnit;
        this.introductionDate = introductionDate;
        this.expirationDate = expirationDate;
        this.acceptedIn = acceptedIn;
    }

    public ISOCurrency(final String name, final String symbol) {
        this(name, symbol, null, null, null, null, null, null, null, null);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public String getDefinition() {
        return this.definition;
    }

    @Override
    public String getAlphabeticCode() {
        return this.alphabeticCode;
    }

    @Override
    public String getNumericCode() {
        return this.numericCode;
    }

    @Override
    public String getMajorUnitSymbol() {
        return this.majorUnitSymbol;
    }

    @Override
    public String getMinorUnitSymbol() {
        return this.minorUnitSymbol;
    }

    @Override
    public double getRatioOfMinorToMajorUnit() {
        return this.ratioOfMinorToMajorUnit;
    }

    @Override
    public TimeDate getIntroductionDate() {
        return this.introductionDate;
    }

    @Override
    public TimeDate getExpirationDate() {
        return this.expirationDate;
    }

    @Override
    public Set<Locale> getAcceptedIn() {
        return this.acceptedIn;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
