package com.chooseacab.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity of Location table.
 */
@Entity
@Table(name = "CC_LOCATIONS")
public class Location implements Serializable {

	/**
     * Propery for ID Column for CC_LOCATIONS.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Propery for NAME Column for CC_LOCATIONS.
     */
    @Column(name = "NAME")
    private String name;

    /**
     * Propery for ZIP Column for CC_LOCATIONS.
     */
    @Column(name = "ZIP")
    private int zipCode;

    /**
     * Method to get Id for CC_LOCATIONS record.
     * @return Long - Id for CC_LOCATIONS record.
     */
    public final Long getId() {
        return id;
    }

    /**
     * Method to set Id for CC_LOCATIONS record.
     * @param id - Id for CC_LOCATIONS record.
     */
    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * Method to get Name for CC_LOCATIONS record.
     * @return String - Name for CC_LOCATIONS record.
     */
    public final String getName() {
        return name;
    }

    /**
     * Method to set name for CC_LOCATIONS record.
     * @param name - name for CC_LOCATIONS record.
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Method to get zipcode for CC_LOCATIONS record.
     * @return int - zipcode for CC_LOCATIONS record.
     */
    public final int getZipCode() {
        return zipCode;
    }

    /**
     * Method to set zipCode for CC_LOCATIONS record.
     * @param name - zipCode for CC_LOCATIONS record.
     */
    public final void setZipCode(final int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Overriding the equals method to compare two records for Locations.
     * @param object - Object to compare.
     * @return boolean - True/False based on Location instances are equals or not.
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Location)) {
            return false;
        }

        final Location other = (Location) object;

        return new EqualsBuilder()
                .append(this.getName(), other.getName())
                .append(this.getZipCode(), other.getZipCode())
                .isEquals();
    }

    /**
     * Overriding the hshcode method to return random hashcode value for Type object.
     * @return int - hshcode value.
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getName())
                .append(this.getZipCode())
                .toHashCode();
    }
}