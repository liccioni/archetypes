package net.liccioni.archetypes.preference;

import lombok.Value;
import net.liccioni.archetypes.quantity.Quantity;

@Value
public class Preference {

    Quantity preferenceWeight;
    PreferenceType preferenceType;
    PreferenceOption option;
}
