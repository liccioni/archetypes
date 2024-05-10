package net.liccioni.archetypes.relationship;


import lombok.Builder;
import lombok.NonNull;

@Builder(toBuilder = true)
public record PartyRelationshipConstraint(@NonNull String clientRoleName,
                                          @NonNull String supplierRoleName) {

    public boolean canFormRelationship(PartyRole client, PartyRole supplier) {

        return this.clientRoleName.equals(client.getName()) && this.supplierRoleName.equals(supplier.getName());
    }
}
