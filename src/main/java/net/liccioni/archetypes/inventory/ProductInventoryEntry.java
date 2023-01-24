package net.liccioni.archetypes.inventory;


import java.util.HashSet;
import java.util.Set;
import net.liccioni.archetypes.TimeDate;
import net.liccioni.archetypes.order.PurchaseOrder;
import net.liccioni.archetypes.rule.RuleContext;

/**
 * @generated
 */
public class ProductInventoryEntry extends InventoryEntry {

    /**
     * @generated
     */
    private Set<PurchaseOrder> purchaseOrder;
    /**
     * @generated
     */
    private RestockPolicy restockPolicy;

    /**
     * @generated
     */
    public Set<PurchaseOrder> getPurchaseOrder() {
        if (this.purchaseOrder == null) {
            this.purchaseOrder = new HashSet<PurchaseOrder>();
        }
        return this.purchaseOrder;
    }

    /**
     * @generated
     */
    public void setPurchaseOrder(Set<PurchaseOrder> purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

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
