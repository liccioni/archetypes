package net.liccioni.archetypes.quantity;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class DerivedUnit extends Unit {
    
    
    /**
    * @generated
    */
    private Set<DerivedUnitTerm> terms;
    
    

    
    /**
    * @generated
    */
    public Set<DerivedUnitTerm> getTerms() {
        if (this.terms == null) {
            this.terms = new HashSet<DerivedUnitTerm>();
        }
        return this.terms;
    }
    
    /**
    * @generated
    */
    public void setTerms(Set<DerivedUnitTerm> terms) {
        this.terms = terms;
    }
    
    
    
}