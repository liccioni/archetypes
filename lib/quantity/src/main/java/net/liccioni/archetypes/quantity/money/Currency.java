package net.liccioni.archetypes.quantity.money;

import java.util.Objects;
import java.util.Set;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.address.Locale;
import net.liccioni.archetypes.quantity.Metric;

public interface Currency extends Metric {

    String getAlphabeticCode();

    String getNumericCode();

    String getMajorUnitSymbol();

    String getMinorUnitSymbol();

    Double getRatioOfMinorToMajorUnit();

    TimeDate getIntroductionDate();

    TimeDate getExpirationDate();

    Set<Locale> getAcceptedIn();

    default boolean isEqualTo(Currency other) {
        return Objects.equals(getAlphabeticCode(), other.getAlphabeticCode());
    }

    @Override
    default boolean isEqualTo(Metric metric) {
        if (metric instanceof Currency) {
            return isEqualTo((Currency) metric);
        }
        return false;
    }
}
