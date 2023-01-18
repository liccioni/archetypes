package net.liccioni.archetypes.quantity;

import java.util.Set;
import java.util.HashSet;


/**
* @generated
*/
public class UnitConverter {
    
    
    

    
    

    //                          Operations                                  
    
    
    /**
    * @generated
    */
    private Set<StandardConversion> converters;

  /**
    * @generated
    */
    public Set<StandardConversion> getConverters() {
        if (this.converters == null) {
            this.converters = new HashSet<StandardConversion>();
        }
        return this.converters;
    }

  /**
    * @generated
    */
    public void setConverters(Set<StandardConversion> converters) {
        this.converters = converters;
    }

  /**
    * @generated
    */
    public Quantity convert(Quantity quantity, Unit targetUnit) {
        //TODO
        return null;
    }
    
    
}
