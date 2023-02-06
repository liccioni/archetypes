package net.liccioni.archetypes.party;


import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.common.TimeDate;

@Value
@Builder(toBuilder = true)
public class PersonName {

    String familyName;
    String givenName;
    TimeDate validFrom;
    TimeDate validTo;
}
