package net.liccioni.archetypes.preference;

import java.util.Set;
import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.uniqueid.UniqueIdentifier;

@Value
@Builder
public class PreferenceType {

    UniqueIdentifier id;
    String name;
    String description;
    Set<PreferenceOption> preferenceOptions;
}
