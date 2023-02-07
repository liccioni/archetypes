package net.liccioni.archetypes.address;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import net.liccioni.archetypes.common.TimeDate;

@Value
@Builder(toBuilder = true)
public class AddressProperties {

    TimeDate validFrom;
    TimeDate validTo;
    @Builder.Default
    Set<String> use = new HashSet<>();
    @NonNull
    Address address;
}
