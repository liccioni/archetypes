package net.liccioni.archetypes.rule;


/**
 * @generated
 */
public class Proposition extends RuleElement {

    /**
     * @generated
     */
    private boolean value;


    /**
     * @generated
     */
    public boolean getValue() {
        return this.value;
    }

    /**
     * @generated
     */
    public void setValue(boolean value) {
        this.value = value;
    }


    //                          Operations


    /**
     * @generated
     */
    public Proposition and(Proposition rhs) {
        //TODO
        return null;
    }


    /**
     * @generated
     */
    public Proposition or(Proposition rhs) {
        //TODO
        return null;
    }


    /**
     * @generated
     */
    public Proposition xor(Proposition rhs) {
        //TODO
        return null;
    }


    /**
     * @generated
     */
    public Proposition not() {
        //TODO
        return null;
    }

    @Override
    public String getType() {
        return "Proposition";
    }
}
