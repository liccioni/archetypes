package net.liccioni.archetypes.preference;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.uniqueid.UniqueIdentifier;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public record PreferenceType(UniqueIdentifier id,
                             String name,
                             String description,
                             Set<PreferenceOption> preferenceOptions) {
    @Builder(toBuilder = true)
    public PreferenceType(UniqueIdentifier id,
                          @NonNull String name,
                          String description,
                          Set<PreferenceOption> preferenceOptions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.preferenceOptions = Optional.ofNullable(preferenceOptions).orElseGet(HashSet::new);
    }
}
