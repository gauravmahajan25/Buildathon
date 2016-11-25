package com.chooseacab.service;

import com.chooseacab.model.Operator;
import com.chooseacab.repository.OperatorJpaRepository;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Test
public class OperatorServiceTest {

	private OperatorJpaRepository operatorJpaRepository;

	@BeforeTest
	public void setup() {
		operatorJpaRepository = mock(OperatorJpaRepository.class);
	}

	@Test
	public void testGetOperators() {
		final Operator operator = new Operator();
		operator.setName("OP1");

		final List<Operator> expected = new ArrayList<>();
		expected.add(operator);

		when(operatorJpaRepository.getOperators()).thenReturn(expected);

		final Collection<Operator> actual = operatorJpaRepository.getOperators();

		Assert.assertEquals(actual.size(), expected.size());
	}
}
