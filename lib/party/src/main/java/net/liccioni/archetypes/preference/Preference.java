package net.liccioni.archetypes.preference;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import net.liccioni.archetypes.quantity.Quantity;

@Value
@Builder(toBuilder = true)
public class Preference {

    @NonNull
    Quantity preferenceWeight;
    @NonNull
    PreferenceType preferenceType;
    @NonNull
    PreferenceOption option;
}
