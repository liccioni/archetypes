package net.liccioni.archetypes.party;


import lombok.Builder;
import lombok.Value;
import net.liccioni.archetypes.common.TimeDate;

@Value
@Builder(toBuilder = true)
public class RegisteredIdentifier {

    String identifier;
    TimeDate validFrom;
    TimeDate validTo;
    String registrationAuthority;
}
