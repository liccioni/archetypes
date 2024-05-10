package net.liccioni.archetypes.address;

import lombok.Builder;
import lombok.NonNull;

@Builder(toBuilder = true)
public record EmailAddress(@NonNull String emailAddress) implements Address {
    @Override
    public String address() {
        return this.emailAddress;
    }
}
