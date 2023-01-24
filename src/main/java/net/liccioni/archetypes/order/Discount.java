package net.liccioni.archetypes.order;


import net.liccioni.archetypes.product.Price;

/**
 * @generated
 */
public abstract class Discount {


    /**
     * @generated
     */
    private String reason;
    /**
     * @generated
     */
    private DiscountType discountType;


    /**
     * @generated
     */
    public String getReason() {
        return this.reason;
    }

    /**
     * @generated
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @generated
     */
    public DiscountType getDiscountType() {
        return this.discountType;
    }

    /**
     * @generated
     */
    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    /**
     * @generated
     */
    public Price calculateDiscountedPrice(Price price) {
        //TODO
        return null;
    }


}
