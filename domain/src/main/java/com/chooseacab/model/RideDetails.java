package com.chooseacab.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity of Ride Details table.
 */
@Entity
@Table(name = "CC_RIDE_DETAILS")
public class RideDetails implements Serializable {

	/**
     * Propery for ID Column for CC_RIDE_DETAILS.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Propery for CC_SOURCE_LOC_ID Column for CC_RIDE_DETAILS.
     */
    @ManyToOne
    @JoinColumn(name = "CC_SOURCE_LOC_ID")
    private Location sourceLocation;

    /**
     * Propery for CC_DESTINATION_LOC_ID Column for CC_RIDE_DETAILS.
     */
    @ManyToOne
    @JoinColumn(name = "CC_DESTINATION_LOC_ID")
    private Location destinationLocation;

    /**
     * Propery for CC_FARE_ID Column for CC_RIDE_DETAILS.
     */
    @ManyToOne
    @JoinColumn(name = "CC_FARE_ID")
    private FareDetails fareDetails;

    /**
     * Method to get Id for CC_RIDE_DETAILS record.
     * @return Long - Id for CC_RIDE_DETAILS record.
     */
    public final Long getId() {
        return id;
    }

    /**
     * Method to set Id for CC_RIDE_DETAILS record.
     * @param id - Id for CC_RIDE_DETAILS record.
     */
    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * Method to get Location based on CC_SOURCE_LOC_ID for CC_RIDE_DETAILS record.
     * @return Location - Source Location for CC_RIDE_DETAILS record.
     */
    public final Location getSourceLocation() {
        return sourceLocation;
    }

    /**
     * Method to set sourceLocation for CC_RIDE_DETAILS record.
     * @param sourceLocation - sourceLocation for CC_RIDE_DETAILS record.
     */
    public final void setSourceLocation(final Location sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    /**
     * Method to get Location based on CC_DESTINATION_LOC_ID for CC_RIDE_DETAILS record.
     * @return Location - Destination Location for CC_RIDE_DETAILS record.
     */
    public final Location getDestinationLocation() {
        return destinationLocation;
    }

    /**
     * Method to set destinationLocation for CC_RIDE_DETAILS record.
     * @param destinationLocation - destinationLocation for CC_RIDE_DETAILS record.
     */
    public final void setDestinationLocation(final Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    /**
     * Method to get FareDetails based on CC_FARE_ID for CC_RIDE_DETAILS record.
     * @return FareDetails - Fare Details for CC_RIDE_DETAILS record.
     */
    public final FareDetails getFareDetails() {
        return fareDetails;
    }

    /**
     * Method to set fareDetails for CC_RIDE_DETAILS record.
     * @param fareDetails - fareDetails for CC_RIDE_DETAILS record.
     */
    public final void setFareDetails(final FareDetails fareDetails) {
        this.fareDetails = fareDetails;
    }

    /**
     * Overriding the equals method to compare two records for Ride details.
     * @param object - Object to compare.
     * @return boolean - True/False based on Operator instances are equals or not.
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof RideDetails)) {
            return false;
        }

        final RideDetails other = (RideDetails) object;

        return new EqualsBuilder()
                .append(this.getSourceLocation(), other.getSourceLocation())
                .append(this.getDestinationLocation(), other.getDestinationLocation())
                .append(this.getFareDetails().getId(), other.getFareDetails().getId())
                .isEquals();
    }

    /**
     * Overriding the hshcode method to return random hashcode value for RideDetails object.
     * @return int - hshcode value.
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getSourceLocation())
                .append(this.getDestinationLocation())
                .append(this.getFareDetails().getId())
                .toHashCode();
    }
}