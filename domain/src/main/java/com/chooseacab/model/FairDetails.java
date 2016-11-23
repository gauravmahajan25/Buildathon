package com.chooseacab.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity of Fair Details table.
 */
@Entity
@Table(name = "CC_FAIR_DETAILS")
public class FairDetails implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FARE")
    private Double fare;

    @Column(name = "DISCOUNT")
    private Integer discount;

    @ManyToOne
    @JoinColumn(name = "CC_OPERATOR_ID")
    private Operator operator;

    @ManyToOne
    @JoinColumn(name = "CC_TYPE_ID")
    private Type type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof FairDetails)) {
            return false;
        }

        final FairDetails other = (FairDetails) o;

        return new EqualsBuilder()
                .append(this.getOperator(), other.getOperator())
                .append(this.getType(), other.getType())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getOperator())
                .append(this.getType())
                .toHashCode();
    }
}