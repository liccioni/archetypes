package net.liccioni.archetypes.relationship;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class PartyRelationship {

    @NonNull
    PartyRole supplier;
    @NonNull
    PartyRole client;
    @NonNull
    PartyRelationshipType type;

    public String getName() {

        return this.type.getName();
    }

    public String getDescription() {
        return this.type.getDescription();
    }
}
