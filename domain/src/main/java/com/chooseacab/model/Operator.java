package com.chooseacab.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity of Operator table.
 */
@Entity
@Table(name = "CC_OPERATORS")
public class Operator implements Serializable {

	/**
     * Propery for ID Column for CC_OPERATORS.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Propery for NAME Column for CC_OPERATORS.
     */
    @Column(name = "NAME")
    private String name;

    /**
     * Method to get Id for CC_OPERATORS record.
     * @return Long - Id for CC_OPERATORS record.
     */
    public final Long getId() {
        return id;
    }

    /**
     * Method to set Id for CC_OPERATORS record.
     * @param id - Id for CC_OPERATORS record.
     */
    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * Method to get Name for CC_OPERATORS record.
     * @return String - name for CC_OPERATORS record.
     */
    public final String getName() {
        return name;
    }

    /**
     * Method to set name for CC_OPERATORS record.
     * @param name - name for CC_OPERATORS record.
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Overriding the equals method to compare two records for Operators.
     * @param object - Object to compare.
     * @return boolean - True/False based on Operator instances are equals or not.
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Operator)) {
            return false;
        }

        final Operator other = (Operator) object;

        return new EqualsBuilder()
                .append(this.getName(), other.getName())
                .isEquals();
    }

    /**
     * Overriding the hshcode method to return random hashcode value for Operator object.
     * @return int - hshcode value.
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getName())
                .toHashCode();
    }
}