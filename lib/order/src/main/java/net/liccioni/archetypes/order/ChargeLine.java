package net.liccioni.archetypes.order;


import net.liccioni.archetypes.money.Money;

/**
 * @generated
 */
public class ChargeLine {


    /**
     * @generated
     */
    private Money amount;
    /**
     * @generated
     */
    private String description;
    /**
     * @generated
     */
    private String comment;
    /**
     * @generated
     */
    private TaxOnLine taxOnLine;


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
    public String getDescription() {
        return this.description;
    }

    /**
     * @generated
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @generated
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * @generated
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @generated
     */
    public TaxOnLine getTaxOnLine() {
        return this.taxOnLine;
    }

    /**
     * @generated
     */
    public void setTaxOnLine(TaxOnLine taxOnLine) {
        this.taxOnLine = taxOnLine;
    }


}
