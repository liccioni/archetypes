package net.liccioni.archetypes.product;

import java.util.Set;
import java.util.HashSet;


/**
* @generated
*/
public class ArbitraryPrice extends Price {

  /**
    * @generated
    */
    private Set<PartySignature> approvedBy;

  /**
    * @generated
    */
    public Set<PartySignature> getApprovedBy() {
        if (this.approvedBy == null) {
            this.approvedBy = new HashSet<PartySignature>();
        }
        return this.approvedBy;
    }

  /**
    * @generated
    */
    public void setApprovedBy(Set<PartySignature> approvedBy) {
        this.approvedBy = approvedBy;
    }
    
    
    

    
    
}
