package net.liccioni.archetypes.uniqueid;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class UniqueIdentifier {

    private final String id;
}
