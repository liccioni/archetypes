package net.liccioni.archetypes.product;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class ConditionalPropositionOfInclusion extends PropositionOfInclusion {
    
    
    /**
    * @generated
    */
    private PropositionOfInclusion condition;
    
    /**
    * @generated
    */
    private Set<PropositionOfInclusion> body;
    
    

    
    /**
    * @generated
    */
    public Set<PropositionOfInclusion> getBody() {
        if (this.body == null) {
            this.body = new HashSet<PropositionOfInclusion>();
        }
        return this.body;
    }
    
    /**
    * @generated
    */
    public void setBody(Set<PropositionOfInclusion> body) {
        this.body = body;
    }
    
    
    /**
    * @generated
    */
    public PropositionOfInclusion getCondition() {
        return this.condition;
    }
    
    /**
    * @generated
    */
    public void setCondition(PropositionOfInclusion condition) {
        this.condition = condition;
    }
    
    
    

    //                          Operations                                  
    
    
    
    /**
    * @generated
    */
    public boolean addCondition(PropositionOfInclusion conditionProposition)
    {
        //TODO
        return false;
    }
    
    
    
    /**
    * @generated
    */
    public boolean addBody(PropositionOfInclusion conditionProposition)
    {
        //TODO
        return false;
    }
    
    
}
