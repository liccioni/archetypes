package net.liccioni.archetypes.money;

import java.util.Objects;
import java.util.Set;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.address.Locale;
import net.liccioni.archetypes.quantity.Metric;

public interface Currency extends Metric {

    String alphabeticCode();

    String numericCode();

    String majorUnitSymbol();

    String minorUnitSymbol();

    Double ratioOfMinorToMajorUnit();

    TimeDate introductionDate();

    TimeDate expirationDate();

    Set<Locale> acceptedIn();

    default boolean isEqualTo(Currency other) {
        return Objects.equals(alphabeticCode(), other.alphabeticCode());
    }

    @Override
    default boolean isEqualTo(Metric metric) {
        if (metric instanceof Currency) {
            return isEqualTo((Currency) metric);
        }
        return false;
    }
}
