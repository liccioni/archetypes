package net.liccioni.archetypes.order;

import java.util.HashSet;
import java.util.Set;
import net.liccioni.archetypes.TimeDate;
import net.liccioni.archetypes.product.ProductIdentifier;
import net.liccioni.archetypes.product.SerialNumber;
import net.liccioni.archetypes.quantity.money.Money;

/**
 * @generated
 */
public class OrderLine {


    /**
     * @generated
     */
    private ProductIdentifier productType;

    /**
     * @generated
     */
    private SerialNumber serialNumber;

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
    private int numberOrdered;

    /**
     * @generated
     */
    private Money unitPrice;

    /**
     * @generated
     */
    private TimeDate expectedDeliveryDate;

    /**
     * @generated
     */
    private ChargeLine chargeLine;

    /**
     * @generated
     */
    private OrderLineIdentifier orderLineIdentifier;

    /**
     * @generated
     */
    private Set<TaxOnLine> taxes;

    /**
     * @generated
     */
    private DeliveryReceiver orderLineReceiver;


    /**
     * @generated
     */
    public ProductIdentifier getProductType() {
        return this.productType;
    }

    /**
     * @generated
     */
    public void setProductType(ProductIdentifier productType) {
        this.productType = productType;
    }

    /**
     * @generated
     */
    public SerialNumber getSerialNumber() {
        return this.serialNumber;
    }

    /**
     * @generated
     */
    public void setSerialNumber(SerialNumber serialNumber) {
        this.serialNumber = serialNumber;
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
    public int getNumberOrdered() {
        return this.numberOrdered;
    }

    /**
     * @generated
     */
    public void setNumberOrdered(int numberOrdered) {
        this.numberOrdered = numberOrdered;
    }

    /**
     * @generated
     */
    public Money getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * @generated
     */
    public void setUnitPrice(Money unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @generated
     */
    public TimeDate getExpectedDeliveryDate() {
        return this.expectedDeliveryDate;
    }

    /**
     * @generated
     */
    public void setExpectedDeliveryDate(TimeDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    /**
     * @generated
     */
    public DeliveryReceiver getOrderLineReceiver() {
        return this.orderLineReceiver;
    }

    /**
     * @generated
     */
    public void setOrderLineReceiver(DeliveryReceiver orderLineReceiver) {
        this.orderLineReceiver = orderLineReceiver;
    }


    /**
     * @generated
     */
    public Set<TaxOnLine> getTaxes() {
        if (this.taxes == null) {
            this.taxes = new HashSet<TaxOnLine>();
        }
        return this.taxes;
    }

    /**
     * @generated
     */
    public void setTaxes(Set<TaxOnLine> taxes) {
        this.taxes = taxes;
    }


    /**
     * @generated
     */
    public OrderLineIdentifier getOrderLineIdentifier() {
        return this.orderLineIdentifier;
    }

    /**
     * @generated
     */
    public void setOrderLineIdentifier(OrderLineIdentifier orderLineIdentifier) {
        this.orderLineIdentifier = orderLineIdentifier;
    }


    /**
     * @generated
     */
    public ChargeLine getChargeLine() {
        return this.chargeLine;
    }

    /**
     * @generated
     */
    public void setChargeLine(ChargeLine chargeLine) {
        this.chargeLine = chargeLine;
    }


}
