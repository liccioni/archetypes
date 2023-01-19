package net.liccioni.archetypes.product;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class ProductInstance {
    
    /**
    * @generated
    */
    private String name;
    
    
    /**
    * @generated
    */
    private Price agreed;
    
    /**
    * @generated
    */
    private ProductType productType;
    
    /**
    * @generated
    */
    private ArbitraryPrice applied;
    
    /**
    * @generated
    */
    private Batch batch;
    
    /**
    * @generated
    */
    private Set<ProductFeatureInstance> features;
    
    /**
    * @generated
    */
    private SerialNumber serialNumber;
    
    

    /**
    * @generated
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * @generated
    */
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    /**
    * @generated
    */
    public ProductType getProductType() {
        return this.productType;
    }
    
    /**
    * @generated
    */
    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
    
    
    /**
    * @generated
    */
    public Price getAgreed() {
        return this.agreed;
    }
    
    /**
    * @generated
    */
    public void setAgreed(Price agreed) {
        this.agreed = agreed;
    }
    
    
    /**
    * @generated
    */
    public ArbitraryPrice getApplied() {
        return this.applied;
    }
    
    /**
    * @generated
    */
    public void setApplied(ArbitraryPrice applied) {
        this.applied = applied;
    }
    
    
    /**
    * @generated
    */
    public Batch getBatch() {
        return this.batch;
    }
    
    /**
    * @generated
    */
    public void setBatch(Batch batch) {
        this.batch = batch;
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
    public Set<ProductFeatureInstance> getFeatures() {
        if (this.features == null) {
            this.features = new HashSet<ProductFeatureInstance>();
        }
        return this.features;
    }
    
    /**
    * @generated
    */
    public void setFeatures(Set<ProductFeatureInstance> features) {
        this.features = features;
    }
    
    
    
}
