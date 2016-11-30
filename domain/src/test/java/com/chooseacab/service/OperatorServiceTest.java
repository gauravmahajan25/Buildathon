package com.chooseacab.service;

import com.chooseacab.model.Operator;
import com.chooseacab.repository.OperatorJpaRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for OperatorService.
 */
@Test
public class OperatorServiceTest {

	private static OperatorJpaRepository operatorJpaRepository;

	/**
	 * Setup.
	 */
	@BeforeTest
	public final void setup() {
		operatorJpaRepository = mock(OperatorJpaRepository.class);
	}

	/**
	 * Test Get Operators.
	 */
	@Test
	public final void testGetOperators() {
		final Operator operator = new Operator();
		operator.setName("OP1");

		final List<Operator> expected = new ArrayList<>();
		expected.add(operator);

		when(operatorJpaRepository.getOperators()).thenReturn(expected);

		final Collection<Operator> actual = operatorJpaRepository.getOperators();

		Assert.assertEquals(actual.size(), expected.size());
	}
}
