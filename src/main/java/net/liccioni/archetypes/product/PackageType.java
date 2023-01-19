package net.liccioni.archetypes.product;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class PackageType extends ProductType {
    
    
    /**
    * @generated
    */
    private Set<ProductSet> productSet;
    
    /**
    * @generated
    */
    private Set<ProductType> components;
    
    /**
    * @generated
    */
    private Set<PropositionOfInclusion> propositionOfInclusion;
    
    

    
    /**
    * @generated
    */
    public Set<ProductSet> getProductSet() {
        if (this.productSet == null) {
            this.productSet = new HashSet<ProductSet>();
        }
        return this.productSet;
    }
    
    /**
    * @generated
    */
    public void setProductSet(Set<ProductSet> productSet) {
        this.productSet = productSet;
    }
    
    
    /**
    * @generated
    */
    public Set<PropositionOfInclusion> getPropositionOfInclusion() {
        if (this.propositionOfInclusion == null) {
            this.propositionOfInclusion = new HashSet<PropositionOfInclusion>();
        }
        return this.propositionOfInclusion;
    }
    
    /**
    * @generated
    */
    public void setPropositionOfInclusion(Set<PropositionOfInclusion> propositionOfInclusion) {
        this.propositionOfInclusion = propositionOfInclusion;
    }
    
    
    /**
    * @generated
    */
    public Set<ProductType> getComponents() {
        if (this.components == null) {
            this.components = new HashSet<ProductType>();
        }
        return this.components;
    }
    
    /**
    * @generated
    */
    public void setComponents(Set<ProductType> components) {
        this.components = components;
    }
    
    
    

    //                          Operations                                  
    
    
    
    /**
    * @generated
    */
    public boolean addProductType(ProductType productType)
    {
        //TODO
        return false;
    }
    
    
    
    /**
    * @generated
    */
    public boolean addProductSet(ProductSet set)
    {
        //TODO
        return false;
    }
    
    
    
    /**
    * @generated
    */
    public boolean addPropositionOfInclusion(PropositionOfInclusion propositionOfInclusion)
    {
        //TODO
        return false;
    }
    
    
    
    /**
    * @generated
    */
    public boolean validate(PackageInstance packageInstance)
    {
        //TODO
        return false;
    }
    
    
}
