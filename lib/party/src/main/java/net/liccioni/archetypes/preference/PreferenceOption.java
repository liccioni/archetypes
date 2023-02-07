package net.liccioni.archetypes.preference;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class PreferenceOption {

    @NonNull
    String name;
    String description;
}
