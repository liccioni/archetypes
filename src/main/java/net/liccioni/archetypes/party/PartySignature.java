package net.liccioni.archetypes.party;


import net.liccioni.archetypes.TimeDate;

/**
 * @generated
 */
public class PartySignature {

    /**
     * @generated
     */
    private TimeDate when;

    /**
     * @generated
     */
    private String reason;


    /**
     * @generated
     */
    private PartyAuthentication authentication;

    /**
     * @generated
     */
    private PartyIdentifier partyIdentifier;


    /**
     * @generated
     */
    public TimeDate getWhen() {
        return this.when;
    }

    /**
     * @generated
     */
    public void setWhen(TimeDate when) {
        this.when = when;
    }


    /**
     * @generated
     */
    public String getReason() {
        return this.reason;
    }

    /**
     * @generated
     */
    public void setReason(String reason) {
        this.reason = reason;
    }


    /**
     * @generated
     */
    public PartyIdentifier getPartyIdentifier() {
        return this.partyIdentifier;
    }

    /**
     * @generated
     */
    public void setPartyIdentifier(PartyIdentifier partyIdentifier) {
        this.partyIdentifier = partyIdentifier;
    }

    /**
     * @generated
     */
    public PartyAuthentication getAuthentication() {
        return this.authentication;
    }

    /**
     * @generated
     */
    public void setAuthentication(PartyAuthentication authentication) {
        this.authentication = authentication;
    }
}
