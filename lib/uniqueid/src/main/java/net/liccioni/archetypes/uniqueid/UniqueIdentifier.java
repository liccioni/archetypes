package net.liccioni.archetypes.uniqueid;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public class UniqueIdentifier {

    @NonNull
    private final String id;
}
