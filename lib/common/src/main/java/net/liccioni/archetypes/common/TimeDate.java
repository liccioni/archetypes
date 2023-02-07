package net.liccioni.archetypes.common;

import java.time.Instant;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class TimeDate {

    @NonNull
    Instant value;
}
