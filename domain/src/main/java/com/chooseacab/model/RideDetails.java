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

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CC_SOURCE_ID")
    private Location sourceLocation;

    @ManyToOne
    @JoinColumn(name = "CC_DESTINATION_ID")
    private Location destinationLocation;

    @ManyToOne
    @JoinColumn(name = "CC_FAIR_ID")
    private FairDetails fairDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(Location sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public FairDetails getFairDetails() {
        return fairDetails;
    }

    public void setFairDetails(FairDetails fairDetails) {
        this.fairDetails = fairDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof RideDetails)) {
            return false;
        }

        final RideDetails other = (RideDetails) o;

        return new EqualsBuilder()
                .append(this.getSourceLocation(), other.getSourceLocation())
                .append(this.getDestinationLocation(), other.getDestinationLocation())
                .append(this.getFairDetails().getId(), other.getFairDetails().getId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getSourceLocation())
                .append(this.getDestinationLocation())
                .append(this.getFairDetails().getId())
                .toHashCode();
    }
}