package net.liccioni.archetypes.product;


/**
 * @generated
 */
public class PropositionOfInclusion {

    /**
     * @generated
     */
    private String name;

    /**
     * @generated
     */
    private ProductSet productSet;

    /**
     * @generated
     */
    private int minimum;

    /**
     * @generated
     */
    private int maximum;


    /**
     * @generated
     */
    private PackageInstance targetPackage;


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
    public ProductSet getProductSet() {
        return this.productSet;
    }

    /**
     * @generated
     */
    public void setProductSet(ProductSet productSet) {
        this.productSet = productSet;
    }


    /**
     * @generated
     */
    public int getMinimum() {
        return this.minimum;
    }

    /**
     * @generated
     */
    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }


    /**
     * @generated
     */
    public int getMaximum() {
        return this.maximum;
    }

    /**
     * @generated
     */
    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }


    /**
     * @generated
     */
    public PackageInstance getTargetPackage() {
        return this.targetPackage;
    }

    /**
     * @generated
     */
    public void setTargetPackage(PackageInstance targetPackage) {
        this.targetPackage = targetPackage;
    }


    //                          Operations                                  


    /**
     * @generated
     */
    public boolean isSubSetOf(PackageInstance packageInstance) {
        //TODO
        return false;
    }


}
