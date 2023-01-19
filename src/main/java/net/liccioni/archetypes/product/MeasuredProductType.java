package net.liccioni.archetypes.product;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class MeasuredProductType extends ProductType {
    
    
    /**
    * @generated
    */
    private Metric preferredMetric;
    
    /**
    * @generated
    */
    private Set<Metric> possibleMetrics;
    
    

    
    /**
    * @generated
    */
    public Metric getPreferredMetric() {
        return this.preferredMetric;
    }
    
    /**
    * @generated
    */
    public void setPreferredMetric(Metric preferredMetric) {
        this.preferredMetric = preferredMetric;
    }
    
    
    /**
    * @generated
    */
    public Set<Metric> getPossibleMetrics() {
        if (this.possibleMetrics == null) {
            this.possibleMetrics = new HashSet<Metric>();
        }
        return this.possibleMetrics;
    }
    
    /**
    * @generated
    */
    public void setPossibleMetrics(Set<Metric> possibleMetrics) {
        this.possibleMetrics = possibleMetrics;
    }
    
    
    
}
