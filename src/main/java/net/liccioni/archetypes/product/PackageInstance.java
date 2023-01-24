package net.liccioni.archetypes.product;

import java.util.HashSet;
import java.util.Set;

/**
 * @generated
 */
public class PackageInstance extends ProductInstance {


    /**
     * @generated
     */
    private Set<ProductInstance> components;


    /**
     * @generated
     */
    public Set<ProductInstance> getComponents() {
        if (this.components == null) {
            this.components = new HashSet<ProductInstance>();
        }
        return this.components;
    }

    /**
     * @generated
     */
    public void setComponents(Set<ProductInstance> components) {
        this.components = components;
    }


}
