package net.liccioni.archetypes.preference;

import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.quantity.Quantity;

@Value
@Builder(toBuilder = true)
public class Preference {

    Quantity preferenceWeight;
    PreferenceType preferenceType;
    PreferenceOption option;
}
