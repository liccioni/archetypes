package net.liccioni.archetypes.product;


import net.liccioni.archetypes.TimeDate;

/**
 * @generated
 */
public class ServiceType extends ProductType {

    /**
     * @generated
     */
    private TimeDate startPeriodOfOperation;

    /**
     * @generated
     */
    private TimeDate endPeriodOfOperation;


    /**
     * @generated
     */
    public TimeDate getStartPeriodOfOperation() {
        return this.startPeriodOfOperation;
    }

    /**
     * @generated
     */
    public void setStartPeriodOfOperation(TimeDate startPeriodOfOperation) {
        this.startPeriodOfOperation = startPeriodOfOperation;
    }


    /**
     * @generated
     */
    public TimeDate getEndPeriodOfOperation() {
        return this.endPeriodOfOperation;
    }

    /**
     * @generated
     */
    public void setEndPeriodOfOperation(TimeDate endPeriodOfOperation) {
        this.endPeriodOfOperation = endPeriodOfOperation;
    }
}
