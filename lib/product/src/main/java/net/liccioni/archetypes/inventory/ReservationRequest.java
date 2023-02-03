package net.liccioni.archetypes.inventory;

import java.util.HashSet;
import java.util.Set;


/**
 * @generated
 */
public class ReservationRequest {


    /**
     * @generated
     */
    private Set<PartySummary> receivers;
    /**
     * @generated
     */
    private Set<PartySummary> requesters;
    /**
     * @generated
     */
    private ReservationIdentifier reservationIdentifier;


    /**
     * @generated
     */
    public Set<PartySummary> getReceivers() {
        if (this.receivers == null) {
            this.receivers = new HashSet<PartySummary>();
        }
        return this.receivers;
    }

    /**
     * @generated
     */
    public void setReceivers(Set<PartySummary> receivers) {
        this.receivers = receivers;
    }

    /**
     * @generated
     */
    public ReservationIdentifier getReservationIdentifier() {
        return this.reservationIdentifier;
    }

    /**
     * @generated
     */
    public void setReservationIdentifier(ReservationIdentifier reservationIdentifier) {
        this.reservationIdentifier = reservationIdentifier;
    }

    /**
     * @generated
     */
    public Set<PartySummary> getRequesters() {
        if (this.requesters == null) {
            this.requesters = new HashSet<PartySummary>();
        }
        return this.requesters;
    }

    /**
     * @generated
     */
    public void setRequesters(Set<PartySummary> requesters) {
        this.requesters = requesters;
    }


}
