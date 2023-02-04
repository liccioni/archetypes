package net.liccioni.archetypes.partyrelationship;


import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.party.PartySignature;

/**
 * @generated
 */
public class AssignedResponsibility {

    /**
     * @generated
     */
    private TimeDate from;

    /**
     * @generated
     */
    private TimeDate to;


    /**
     * @generated
     */
    private PartySignature partySignature;

    /**
     * @generated
     */
    private net.liccioni.archetypes.partyrelationship.Responsibility responsability;


    /**
     * @generated
     */
    public TimeDate getFrom() {
        return this.from;
    }

    /**
     * @generated
     */
    public void setFrom(TimeDate from) {
        this.from = from;
    }


    /**
     * @generated
     */
    public TimeDate getTo() {
        return this.to;
    }

    /**
     * @generated
     */
    public void setTo(TimeDate to) {
        this.to = to;
    }


    /**
     * @generated
     */
    public net.liccioni.archetypes.partyrelationship.Responsibility getResponsability() {
        return this.responsability;
    }

    /**
     * @generated
     */
    public void setResponsability(Responsibility responsability) {
        this.responsability = responsability;
    }


    /**
     * @generated
     */
    public PartySignature getPartySignature() {
        return this.partySignature;
    }

    /**
     * @generated
     */
    public void setPartySignature(PartySignature partySignature) {
        this.partySignature = partySignature;
    }


    //                          Operations


    /**
     * @generated
     */
    public String getName() {
        //TODO
        return "";
    }


    /**
     * @generated
     */
    public String getDescription() {
        //TODO
        return "";
    }
}
