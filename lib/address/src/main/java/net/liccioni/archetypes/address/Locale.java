package net.liccioni.archetypes.address;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public abstract class Locale {

    @NonNull
    private final String identifier;
    @NonNull
    private final String name;
    private final String description;
}
