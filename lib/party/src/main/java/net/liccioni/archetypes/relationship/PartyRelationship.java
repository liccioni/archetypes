package net.liccioni.archetypes.relationship;

import lombok.Builder;
import lombok.NonNull;

@Builder(toBuilder = true)
public record PartyRelationship(@NonNull PartyRole supplier,
                                @NonNull PartyRole client,
                                @NonNull PartyRelationshipType type) {

    public String getName() {

        return this.type.name();
    }

    public String getDescription() {
        return this.type.description();
    }
}
