package com.chooseacab.repository;

import com.chooseacab.model.Type;
import com.chooseacab.repository.impl.TypeAbstractJpaRepositoryImpl;
import org.hibernate.Criteria;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Test class for Type Repository.
 */
public class TypeJpaRepositoryTest {

  private static TypeAbstractJpaRepositoryImpl typeJpaRepository = new TypeAbstractJpaRepositoryImpl();

  @BeforeClass
  protected final void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Test case to test get types.
   */
  @Test
  public final void testGetTypes() {
    final Criteria criteria = mock(Criteria.class);
    TypeAbstractJpaRepositoryImpl spy = spy(typeJpaRepository);

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
