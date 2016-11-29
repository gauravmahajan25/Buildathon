package com.chooseacab.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity of Fare Details table.
 */
@Entity
@Table(name = "CC_FARE_DETAILS")
public class FareDetails implements Serializable {	
    /**
	 * Serial version id
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * Propery for ID Column for CC_FARE_DETAILS.
     */
    
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Propery for FARE Column for CC_FARE_DETAILS.
     */
    @Column(name = "FARE")
    private Double fare;

    /**
     * Propery for DISCOUNT Column for CC_FARE_DETAILS.
     */
    @Column(name = "DISCOUNT")
    private Integer discount;

    /**
     * Join Column for CC_FARE_DETAILS and CC_OPERATORS.
     */
    @ManyToOne
    @JoinColumn(name = "CC_OPERATOR_ID")
    private Operator operator;

    /**
     * Join Column for CC_FARE_DETAILS and CC_TYPES.
     */
    @ManyToOne
    @JoinColumn(name = "CC_TYPE_ID")
    private Type type;

    /**
     * Method to get Id for CC_FARE_DETAILS record.
     * @return Long - Id for CC_FARE_DETAILS record.
     */
    public final Long getId() {
        return id;
    }

    /**
     * Method to set Id for CC_FARE_DETAILS record.
     * @param id - Id for CC_FARE_DETAILS record.
     */
    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * Method to get fare for CC_FARE_DETAILS record.
     * @return Double - fare for CC_FARE_DETAILS record.
     */
    public final Double getFare() {
        return fare;
    }

    /**
     * Method to set fare for CC_FARE_DETAILS record.
     * @param fare - fare for CC_FARE_DETAILS record.
     */
    public final void setFare(final Double fare) {
        this.fare = fare;
    }

    /**
     * Method to get discount for CC_FARE_DETAILS record.
     * @return Integer - discount for CC_FARE_DETAILS record.
     */
    public final Integer getDiscount() {
        return discount;
    }

    /**
     * Method to set discount for CC_FARE_DETAILS record.
     * @param discount - discount for CC_FARE_DETAILS record.
     */
    public final void setDiscount(final Integer discount) {
        this.discount = discount;
    }

    /**
     * Method to get operator for CC_FARE_DETAILS record.
     * @return Operator - operator value for CC_FARE_DETAILS record.
     */
    public final Operator getOperator() {
        return operator;
    }

    /**
     * Method to set operator for CC_FARE_DETAILS record.
     * @param operator - operator for CC_FARE_DETAILS record.
     */
    public final void setOperator(final Operator operator) {
        this.operator = operator;
    }

    /**
     * Method to get type value for CC_FARE_DETAILS record.
     * @return Type - type value for CC_FARE_DETAILS record.
     */
    public final Type getType() {
        return type;
    }

    /**
     * Method to set type for CC_FARE_DETAILS record.
     * @param type - type for CC_FARE_DETAILS record.
     */
    public final void setType(final Type type) {
        this.type = type;
    }

    /**
     * Overriding the equals method to compare two records for FareDetails.
     * @param Object - Objecto to compare.
     * @return boolean - True/False based on FareDetails instances are equals or not.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof FareDetails)) {
            return false;
        }

        final FareDetails other = (FareDetails) o;

        return new EqualsBuilder()
                .append(this.getOperator(), other.getOperator())
                .append(this.getType(), other.getType())
                .isEquals();
    }

    /**
     * Overriding the hshcode method to return random hashcode value for FareDetails object.
     * @return int - hshcode value.
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getOperator())
                .append(this.getType())
                .toHashCode();
    }
}
