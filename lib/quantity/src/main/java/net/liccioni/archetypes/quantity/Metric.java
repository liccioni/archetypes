package net.liccioni.archetypes.quantity;

public interface Metric {

    String name();

    String symbol();

    String definition();

    boolean isEqualTo(Metric metric);
}
