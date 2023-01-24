package net.liccioni.archetypes.rule;


import java.util.List;

/**
 * @generated
 */
public abstract class ActivityRule extends Rule {
    public ActivityRule(final String name, final List<RuleElement> elements) {
        super(name, elements);
    }


    //                          Operations


    /**
     * @generated
     */
    public abstract boolean activity();


}
