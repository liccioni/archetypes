package net.liccioni.archetypes.preference;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.quantity.Quantity;

@Builder(toBuilder = true)
public record Preference(@NonNull
                         Quantity preferenceWeight,
                         @NonNull
                         PreferenceType preferenceType,
                         @NonNull
                         PreferenceOption option) {
}
