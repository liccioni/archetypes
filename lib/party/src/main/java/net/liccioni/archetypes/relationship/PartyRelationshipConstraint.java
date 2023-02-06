package net.liccioni.archetypes.relationship;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PartyRelationshipConstraint {

    String clientRoleName;
    String supplierRoleName;

    public boolean canFormRelationship(PartyRole client, PartyRole supplier) {
        //TODO
        return false;
    }
}
