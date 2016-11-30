package com.chooseacab.rest.operator;

import com.chooseacab.model.Operator;

import java.util.ArrayList;
import java.util.List;

/**
 * A resource representation class for Operator entity.
 */
public class OperatorRepresentation {

	/**
	 * Property for Operator Id.
	 */
	private Long id;

	/**
	 * Property for Operator Name.
	 */
	private String name;
	
	/**
	 * default constructor.
	 */
	public OperatorRepresentation() {
		// default constructor
	}

	/**
	 * Constructor to instantiate Oprator Representation with Operator parameters.
	 * @param operator operator instance
	 */
	public OperatorRepresentation(final Operator operator) {
		setId(operator.getId());
		setName(operator.getName());
	}
	/**
	 * get the id.
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * set the id.
	 * @param id
	 */
	public void setId(final Long id) {
		this.id = id;
	}
	/**
	 * get the name.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * set the name.
	 * @param name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Returns the operator representations for the operators passed.
	 * @param operators operato instance
	 * @return operator list
	 */
	public static List<OperatorRepresentation> toRepresentations(final List<Operator> operators) {
		final List<OperatorRepresentation> representations = new ArrayList<>();

		for (final Operator operator : operators) {
			final OperatorRepresentation representation = new OperatorRepresentation(operator);
			representations.add(representation);
		}
		return representations;
	}
}
