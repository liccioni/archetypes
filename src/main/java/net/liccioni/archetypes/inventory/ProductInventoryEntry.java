package net.liccioni.archetypes.inventory;


import net.liccioni.archetypes.TimeDate;
import net.liccioni.archetypes.rule.RuleContext;

/**
 * @generated
 */
public class ProductInventoryEntry extends InventoryEntry {

    /**
     * @generated
     */
    private RestockPolicy restockPolicy;

    /**
     * @generated
     */
    public RestockPolicy getRestockPolicy() {
        return this.restockPolicy;
    }

    /**
     * @generated
     */
    public void setRestockPolicy(RestockPolicy restockPolicy) {
        this.restockPolicy = restockPolicy;
    }

    /**
     * @generated
     */
    public boolean restock(RuleContext context) {
        //TODO
        return false;
    }

    /**
     * @generated
     */
    public int getQuantityExpectedByDate(TimeDate date) {
        //TODO
        return 0;
    }


}
