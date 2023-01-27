package net.liccioni.archetypes.quantity.money;

import java.util.Set;
import net.liccioni.archetypes.TimeDate;
import net.liccioni.archetypes.address.Locale;
import net.liccioni.archetypes.quantity.Metric;

public interface Currency extends Metric {

    String getAlphabeticCode();

    String getNumericCode();

    String getMajorUnitSymbol();

    String getMinorUnitSymbol();

    double getRatioOfMinorToMajorUnit();

    TimeDate getIntroductionDate();

    TimeDate getExpirationDate();

    Set<Locale> getAcceptedIn();
}
