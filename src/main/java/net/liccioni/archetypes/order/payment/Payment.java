package net.liccioni.archetypes.order.payment;


import net.liccioni.archetypes.TimeDate;
import net.liccioni.archetypes.quantity.money.Money;

/**
 * @generated
 */
public class Payment extends Money {

    /**
     * @generated
     */
    private TimeDate dateMade;

    /**
     * @generated
     */
    private TimeDate dateReceived;

    /**
     * @generated
     */
    private TimeDate dateDue;

    /**
     * @generated
     */
    private TimeDate dateCreated;

    public Payment() {
        super(null, null);
    }


    /**
     * @generated
     */
    public TimeDate getDateMade() {
        return this.dateMade;
    }

    /**
     * @generated
     */
    public void setDateMade(TimeDate dateMade) {
        this.dateMade = dateMade;
    }


    /**
     * @generated
     */
    public TimeDate getDateReceived() {
        return this.dateReceived;
    }

    /**
     * @generated
     */
    public void setDateReceived(TimeDate dateReceived) {
        this.dateReceived = dateReceived;
    }


    /**
     * @generated
     */
    public TimeDate getDateDue() {
        return this.dateDue;
    }

    /**
     * @generated
     */
    public void setDateDue(TimeDate dateDue) {
        this.dateDue = dateDue;
    }


    /**
     * @generated
     */
    public TimeDate getDateCreated() {
        return this.dateCreated;
    }

    /**
     * @generated
     */
    public void setDateCreated(TimeDate dateCreated) {
        this.dateCreated = dateCreated;
    }


}
