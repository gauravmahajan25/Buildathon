package com.chooseacab.repository;

import com.chooseacab.model.Type;

import java.util.List;

/**
 * Test class for Type Repository.
 */
public interface TypeJpaRepositoryTest {

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
        type.setName("OLA");
        final Type uber = new Type();
        type.setName("UBER");
        
        final List<Type> expected= new ArrayList<>();
        expected.add(type);

        doReturn(criteria).when(spy).createCriteria();
        doReturn(criteria).when(criteria).createCriteria(any(String.class));
        doReturn(expected).when(criteria).list();
        final Collection<RideDetails> actual = spy.getTypes();

        Assert.assertEquals(actual.size(), expected.size());
    }
}
