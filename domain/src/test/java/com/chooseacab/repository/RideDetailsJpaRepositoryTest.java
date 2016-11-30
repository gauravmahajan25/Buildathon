package com.chooseacab.repository;

import com.chooseacab.model.*;
import com.chooseacab.repository.impl.RideDetailsAbstractJpaRepositoryImpl;
import com.chooseacab.search.RideDetailsSearch;
import org.hibernate.Criteria;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class RideDetailsJpaRepositoryTest {

    private static RideDetailsAbstractJpaRepositoryImpl rideDetailsJpaRepository = new RideDetailsAbstractJpaRepositoryImpl();

    @BeforeClass
    protected final void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test search ride details.
     */
    @Test
    public final void testSearchRideDetails() {
        Criteria criteria = mock(Criteria.class);
        RideDetailsAbstractJpaRepositoryImpl spy = spy(rideDetailsJpaRepository);

        final Location sourceLocation = new Location();
        sourceLocation.setName("SRC_LOC1");

        final Location destinationLocation = new Location();
        destinationLocation.setName("DEST_LOC1");

        final Operator operator = new Operator();
        operator.setName("OP1");

        final Type type = new Type();
        type.setName("TYP1");

        final FareDetails fareDetails = new FareDetails();
        fareDetails.setOperator(operator);
        fareDetails.setType(type);
        fareDetails.setFare(12d);
        fareDetails.setDiscount(2);

        final RideDetails rideDetails = new RideDetails();
        rideDetails.setSourceLocation(sourceLocation);
        rideDetails.setDestinationLocation(destinationLocation);
        rideDetails.setFareDetails(fareDetails);

        List<RideDetails> expected= new ArrayList<>();
        expected.add(rideDetails);

        doReturn(criteria).when(spy).createCriteria();
        doReturn(criteria).when(criteria).createCriteria(any(String.class));
        doReturn(expected).when(criteria).list();

        final RideDetailsSearch rideDetailsSearch =
            new RideDetailsSearch(1001L,
                                  1001L,
                                  new HashSet<Long>(Arrays.asList(1001L)),
                                  new HashSet<Long>(Arrays.asList(1001L)));

        Collection<RideDetails> actual =
            spy.searchRideDetails(rideDetailsSearch);

        Assert.assertEquals(actual.size(), expected.size());
    }
}
