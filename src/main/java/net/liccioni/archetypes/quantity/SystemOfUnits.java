package net.liccioni.archetypes.quantity;

public enum SystemOfUnits {
    INTERNATIONAL_SYSTEM_OF_UNITS("SI", "BIPM");

    private final String nameOfSystem;

    private final String nameOfStandardizationBody;

    SystemOfUnits(final String nameOfSystem, final String nameOfStandardizationBody) {
        this.nameOfSystem = nameOfSystem;
        this.nameOfStandardizationBody = nameOfStandardizationBody;
    }

    public String getNameOfSystem() {
        return this.nameOfSystem;
    }

    public String getNameOfStandardizationBody() {
        return this.nameOfStandardizationBody;
    }

    @Override
    public String toString() {
        return "SystemOfUnits{" +
                "nameOfSystem='" + getNameOfSystem() + '\'' +
                ", nameOfStandardizationBody='" + getNameOfStandardizationBody() + '\'' +
                "} ";
    }
}
