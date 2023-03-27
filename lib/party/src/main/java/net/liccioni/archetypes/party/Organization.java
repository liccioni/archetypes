package net.liccioni.archetypes.party;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class Organization extends Party {

    @NonNull
    OrganizationName organizationName;

    @Override
    public String getName() {
        return organizationName.getName();
    }
}
