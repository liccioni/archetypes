package net.liccioni.archetypes.common;

import lombok.Builder;
import lombok.NonNull;

import java.time.Instant;

@Builder(toBuilder = true)
public record TimeDate(@NonNull Instant value) {
}
