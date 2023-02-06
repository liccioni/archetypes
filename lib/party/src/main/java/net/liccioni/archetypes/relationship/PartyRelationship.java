package net.liccioni.archetypes.relationship;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PartyRelationship {

    PartyRole supplier;
    PartyRole client;
    PartyRelationshipType type;

    public String getName() {

        return this.type.getName();
    }

    public String getDescription() {
        return this.type.getDescription();
    }
}
