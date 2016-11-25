package com.chooseacab.repository;

import com.chooseacab.model.Location;
import com.chooseacab.repository.impl.LocationJpaRepositoryImpl;

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

/*
 * Test Class for Location Repository.
 */
public class LocationJpaRepositoryTest {

    LocationJpaRepositoryImpl locationJpaRepository = new LocationJpaRepositoryImpl();

    @BeforeClass
    protected void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /*
     * Test case to test get all Location methods.
     */
    @Test
    public void testGetAllLocations() {
        final Criteria criteria = mock(Criteria.class);
        final LocationJpaRepositoryImpl spy = spy(locationJpaRepository);

        final Location location = new Location();
        location.setName("LOC1");
        location.setZipCode(10101);

        final List<Location> expected= new ArrayList<>();
        expected.add(location);

        doReturn(criteria).when(spy).createCriteria();
        doReturn(criteria).when(criteria).createCriteria(any(String.class));
        doReturn(expected).when(criteria).list();

        final Collection<Location> actual = spy.getAllLocations();

        Assert.assertEquals(actual.size(), expected.size());
    }
}
