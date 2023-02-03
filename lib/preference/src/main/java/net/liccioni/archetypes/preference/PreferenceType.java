package net.liccioni.archetypes.preference;

import java.util.HashSet;
import java.util.Set;
import net.liccioni.archetypes.uniqueid.UniqueIdentifier;

/**
 * @generated
 */
public class PreferenceType {

    /**
     * @generated
     */
    private String name;

    /**
     * @generated
     */
    private String description;


    /**
     * @generated
     */
    private UniqueIdentifier uniqueIdentifier;

    /**
     * @generated
     */
    private Set<PreferenceOption> preferenceOptions;


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
    public Set<PreferenceOption> getPreferenceOptions() {
        if (this.preferenceOptions == null) {
            this.preferenceOptions = new HashSet<PreferenceOption>();
        }
        return this.preferenceOptions;
    }

    /**
     * @generated
     */
    public void setPreferenceOptions(Set<PreferenceOption> preferenceOptions) {
        this.preferenceOptions = preferenceOptions;
    }


    /**
     * @generated
     */
    public UniqueIdentifier getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }

    /**
     * @generated
     */
    public void setUniqueIdentifier(UniqueIdentifier uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }
}
