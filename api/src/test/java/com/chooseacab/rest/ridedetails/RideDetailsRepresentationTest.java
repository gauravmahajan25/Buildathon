package com.chooseacab.rest.ridedetails;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for Ride Details Representation
 * 
 */
public class RideDetailsRepresentationTest {

	/**
	 * Test case to test Operator API for Ride Details class.
	 * 
	 */

	@Test
	public void testOperatorName() {
		final RideDetailsRepresentation representation = new RideDetailsRepresentation();
		representation.setOperatorName("OLA");

		final String operatorName = representation.getOperatorName();

		Assert.assertEquals("OLA", operatorName);
	}

	/**
	 * Test case to test type Name Api for Ride Details class.
	 * 
	 */
	@Test
	public void testTypeName() {
		final RideDetailsRepresentation representation = new RideDetailsRepresentation();
		representation.setTypeName("SUV");

		final String typeName = representation.getTypeName();

		Assert.assertEquals("SUV", typeName);
	}

	/**
	 * Test case to test fare API for Ride Details class.
	 * 
	 */
	@Test
	public void testFare() {
		double fare = 2;
		final RideDetailsRepresentation representation = new RideDetailsRepresentation();
		representation.setFare(fare);

		final double expectedFare = representation.getFare();

		Assert.assertEquals(expectedFare, fare, 1);
	}

	/**
	 * Test case to test discount API for Ride Details class.
	 * 
	 */
	@Test
	public void testDiscount() {
		final RideDetailsRepresentation representation = new RideDetailsRepresentation();
		representation.setDiscount(2);

		final int discount = representation.getDiscount();

		Assert.assertEquals(2, discount);
	}
}
