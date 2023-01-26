package net.liccioni.archetypes;

import java.time.Instant;

public class TimeDate {

    private final Instant value;

    public TimeDate() {
        this.value = Instant.now();
    }

    public TimeDate(final Instant value) {
        this.value = value;
    }

    public Instant getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TimeDate{" +
                "value=" + value +
                '}';
    }
}
