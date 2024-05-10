package net.liccioni.archetypes.preference;

import lombok.Builder;
import lombok.NonNull;

@Builder(toBuilder = true)
public record PreferenceOption(@NonNull
                               String name,
                               String description) {
}
