package com.chooseacab.rest.operator;

import com.chooseacab.model.Operator;

import java.util.ArrayList;
import java.util.List;

/**
 * A resource representation class for Operator entity.
 */
public class OperatorRepresentation {

	private Long id;

	private String name;

	public OperatorRepresentation() {
		// default constructor
	}

	/**
	 * Constructor to instantiate Oprator Representation with Operator
	 * parameters.
	 */
	public OperatorRepresentation(Operator operator) {
		setId(operator.getId());
		setName(operator.getName());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the operator representations for the operators passed.
	 */
	public static List<OperatorRepresentation> toRepresentations(List<Operator> operators) {
		final List<OperatorRepresentation> representations = new ArrayList<>();

		for (final Operator operator : operators) {
			final OperatorRepresentation representation = new OperatorRepresentation(operator);
			representations.add(representation);
		}
		return representations;
	}
}
