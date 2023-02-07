package net.liccioni.archetypes.preference;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import net.liccioni.archetypes.uniqueid.UniqueIdentifier;

@Value
@Builder(toBuilder = true)
public class PreferenceType {

    UniqueIdentifier id;
    @NonNull
    String name;
    String description;
    @Builder.Default
    Set<PreferenceOption> preferenceOptions = new HashSet<>();
}
