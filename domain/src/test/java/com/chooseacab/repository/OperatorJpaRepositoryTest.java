package com.chooseacab.repository;

import com.chooseacab.model.Operator;
import com.chooseacab.repository.impl.OperatorJpaRepositoryImpl;

import org.hibernate.Criteria;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

/*
 * Test class for Operator Repository.
 */
public class OperatorJpaRepositoryTest {

	final OperatorJpaRepositoryImpl opearatorJpaRepository = new OperatorJpaRepositoryImpl();

	@BeforeClass
	protected void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/*
	 * Test case for get Operators.
	 */
	@Test
	public void testGetOperators() {
		final Criteria criteria = mock(Criteria.class);
		final OperatorsJpaRepositoryImpl spy = spy(opearatorJpaRepository);

		final Operator operator = new Operator();
		operator.setName("OP1");

		final List<Operator> expected = new ArrayList<>();
		expected.add(operator);

		doReturn(criteria).when(spy).createCriteria();
		doReturn(criteria).when(criteria).createCriteria(any(String.class));
		doReturn(expected).when(criteria).list();

		final Collection<Operator> actual = spy.getOperators();

		Assert.assertEquals(actual.size(), expected.size());
	}
}
