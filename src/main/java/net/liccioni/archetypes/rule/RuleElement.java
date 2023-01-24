package net.liccioni.archetypes.rule;


import java.util.Objects;

/**
 * @generated
 */
public abstract class RuleElement {

    /**
     * @generated
     */
    private String name;

    public RuleElement(final String name) {
        this.name = name;
    }


    /**
     * @generated
     */
    public String getName() {
        return this.name;
    }

    /**
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }


    //                          Operations


    /**
     * @generated
     */
    public abstract String getType();

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RuleElement)) {
            return false;
        }
        RuleElement that = (RuleElement) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    abstract void acceptStack(RuleExecutionStack stack);
}
