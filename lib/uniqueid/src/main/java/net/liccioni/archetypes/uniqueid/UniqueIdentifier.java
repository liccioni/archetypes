package net.liccioni.archetypes.uniqueid;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public class UniqueIdentifier {

    private final String id;
}
