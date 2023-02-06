package net.liccioni.archetypes.party;


import lombok.Value;
import net.liccioni.archetypes.common.TimeDate;

@Value
public class OrganizationName {

    String name;
    String use;
    TimeDate validFrom;
    TimeDate validTo;
}
