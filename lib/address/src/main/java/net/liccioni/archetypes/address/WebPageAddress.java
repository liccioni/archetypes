package net.liccioni.archetypes.address;

import lombok.Builder;

@Builder(toBuilder = true)
public record WebPageAddress(String url) implements Address {

    @Override
    public String address() {
        return this.url;
    }
}
