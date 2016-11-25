package com.chooseacab.repository;

import com.chooseacab.model.Type;
import com.chooseacab.repository.impl.TypeJpaRepositoryImpl;

import org.hibernate.Criteria;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

/**
 * Test class for Type Repository.
 */
public class TypeJpaRepositoryTest {

  TypeJpaRepositoryImpl typeJpaRepository = new TypeJpaRepositoryImpl();

  @BeforeClass
  protected void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetTypes() {
    final Criteria criteria = mock(Criteria.class);
    TypeJpaRepositoryImpl spy = spy(typeJpaRepository);

    final Type ola = new Type();
    ola.setName("OLA");
    final Type uber = new Type();
    uber.setName("UBER");

    final List<Type> expected = new ArrayList<>();
    expected.add(ola);
    expected.add(uber);

    doReturn(criteria).when(spy).createCriteria();
    doReturn(criteria).when(criteria).createCriteria(any(String.class));
    doReturn(expected).when(criteria).list();
    final Collection<Type> actual = spy.getTypes();

    Assert.assertEquals(actual.size(), expected.size());
  }
}
