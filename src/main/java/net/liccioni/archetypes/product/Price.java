package net.liccioni.archetypes.product;


import java.util.Set;
import net.liccioni.archetypes.TimeDate;
import net.liccioni.archetypes.quantity.money.Money;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleOverride;
import net.liccioni.archetypes.rule.RuleSet;

/**
 * @generated
 */
public class Price {

    /**
     * @generated
     */
    private Money amount;

    /**
     * @generated
     */
    private TimeDate validFrom;

    /**
     * @generated
     */
    private TimeDate validTo;


    /**
     * @generated
     */
    private RuleSet preConditions;


    /**
     * @generated
     */
    public Money getAmount() {
        return this.amount;
    }

    /**
     * @generated
     */
    public void setAmount(Money amount) {
        this.amount = amount;
    }


    /**
     * @generated
     */
    public TimeDate getValidFrom() {
        return this.validFrom;
    }

    /**
     * @generated
     */
    public void setValidFrom(TimeDate validFrom) {
        this.validFrom = validFrom;
    }


    /**
     * @generated
     */
    public TimeDate getValidTo() {
        return this.validTo;
    }

    /**
     * @generated
     */
    public void setValidTo(TimeDate validTo) {
        this.validTo = validTo;
    }


    /**
     * @generated
     */
    public RuleSet getPreConditions() {
        return this.preConditions;
    }

    /**
     * @generated
     */
    public void setPreConditions(RuleSet preConditions) {
        this.preConditions = preConditions;
    }


    //                          Operations


    /**
     * @generated
     */
    public boolean isValid(RuleContext context, Set<RuleOverride> overrides) {
        //TODO
        return false;
    }
}
