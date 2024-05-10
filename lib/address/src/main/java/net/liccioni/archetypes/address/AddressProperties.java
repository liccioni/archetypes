package net.liccioni.archetypes.address;

import lombok.Builder;
import lombok.NonNull;
import net.liccioni.archetypes.common.TimeDate;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record AddressProperties(TimeDate validFrom,
                                TimeDate validTo,
                                Set<String> use,
                                @NonNull Address address) {
    @Builder(toBuilder = true)
    public AddressProperties(TimeDate validFrom, TimeDate validTo, Set<String> use, @NonNull Address address) {
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.use = Optional.ofNullable(use).orElseGet(HashSet::new);
        this.address = address;
    }
}
