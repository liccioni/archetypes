package net.liccioni.archetypes.quantity;

public enum SIBaseUnit implements Unit {

    SECOND("s", "time"),
    METRE("m", "length"),
    KILOGRAM("kg", "mass"),
    AMPERE("A", "electric current"),
    KELVIN("K", "thermodynamic temperature"),
    MOLE("mol", "amount of substance"),
    CANDELA("cd", "luminous intensity");
    private final String symbol;
    private final String definition;
    private final SystemOfUnits systemOfUnits = SystemOfUnits.INTERNATIONAL_SYSTEM_OF_UNITS;

    SIBaseUnit(final String symbol, final String definition) {
        this.symbol = symbol;
        this.definition = definition;
    }

//    @Override
//    public String name() {
//        return this.name().toLowerCase();
//    }

    @Override
    public String symbol() {
        return this.symbol;
    }

    @Override
    public String definition() {
        return this.definition;
    }

    @Override
    public SystemOfUnits systemOfUnits() {
        return this.systemOfUnits;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name() + '\'' +
                ", symbol='" + symbol() + '\'' +
                ", definition='" + definition() + '\'' +
                ", systemOfUnits=" + systemOfUnits +
                "} ";
    }
}
