package net.liccioni.archetypes.preference;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class PreferenceOption {

    String name;
    String description;
}
