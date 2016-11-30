package com.chooseacab.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity of Type table.
 */
@Entity
@Table(name = "CC_TYPES")
public class Type implements Serializable {
	
	/**
     * Propery for ID Column for CC_TYPES.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Propery for NAME Column for CC_TYPES.
     */
    
    @Column(name = "NAME")
    private String name;

    /**
     * Method to get Id for CC_TYPES record.
     * @return Long - Id for CC_TYPES record.
     */
    public final Long getId() {
        return id;
    }

    /**
     * Method to set Id for CC_TYPES record.
     * @param id - Id for CC_TYPES record
     */
    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * Method to get name for CC_TYPES record.
     * @return String - name for CC_TYPES record.
     */
    public final String getName() {
        return name;
    }

    /**
     * Method to set name for CC_TYPES record.
     * @param name - name for CC_TYPES record.
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Overriding the equals method to compare two records for Types.
     * @param object - Object to compare.
     * @return boolean - True/False based on Type instances are equals or not.
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Type)) {
            return false;
        }

        final Type other = (Type) object;

        return new EqualsBuilder()
                .append(this.getName(), other.getName())
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
                .toHashCode();
    }
}