package net.liccioni.archetypes.address;

public sealed interface Address permits EmailAddress, GeographicAddress, WebPageAddress, TelecomAddress {
    String address();
}
