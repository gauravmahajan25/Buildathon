package com.chooseacab.repository.impl;

import com.chooseacab.model.RideDetails;
import com.chooseacab.repository.RideDetailsJpaRepository;
import com.chooseacab.search.RideDetailsSearch;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RideDetailsAbstractJpaRepositoryImpl extends AbstractJpaRepositoryImpl<RideDetails>
    implements RideDetailsJpaRepository {

    /**
     * @param rideDetailsSearch
     * @return list of ride details.
     */
    @Override
    public final List<RideDetails> searchRideDetails(final RideDetailsSearch rideDetailsSearch){
        Criteria criteria = createSearchCriteria(rideDetailsSearch);

        return criteria.list();
    }

    private Criteria createSearchCriteria(final RideDetailsSearch rideDetailsSearch){
        final Criteria criteria = createCriteria();

        if (rideDetailsSearch.getSourceId() != null ) {
            criteria.createCriteria("sourceLocation", "sourceLocation");
        }

        if (rideDetailsSearch.getDestinationId() != null ) {
            criteria.createCriteria("destinationLocation", "destinationLocation");
        }

        if (!rideDetailsSearch.getOperatorIds().isEmpty()
            || !rideDetailsSearch.getTypeIds().isEmpty()) {
            criteria.createCriteria("fareDetails", "fareDetails");
        }

        if (!rideDetailsSearch.getOperatorIds().isEmpty()) {
            criteria.createCriteria("fareDetails.operator", "operator");
        }

        if (!rideDetailsSearch.getTypeIds().isEmpty()) {
            criteria.createCriteria("fareDetails.type", "type");
        }

        searchSourceId(rideDetailsSearch, criteria);
        searchDestinationId(rideDetailsSearch, criteria);
        searchOperatorIds(rideDetailsSearch, criteria);
        searchTypeIds(rideDetailsSearch, criteria);

        return criteria;
    }

    /**
     * Search by source id.
     * @param rideDetailsSearch
     * @param criteria
     */
    private void searchSourceId(final RideDetailsSearch rideDetailsSearch,
                                            Criteria criteria) {
        if (rideDetailsSearch.getSourceId() != null) {
            criteria.add(Restrictions.eq("sourceLocation.id", rideDetailsSearch.getSourceId()));
        }
    }

    /**
     * Search by destination id.
     * @param rideDetailsSearch
     * @param criteria
     */
    private void searchDestinationId(final RideDetailsSearch rideDetailsSearch, Criteria criteria) {
        if (rideDetailsSearch.getDestinationId() != null) {
            criteria.add(Restrictions.eq("destinationLocation.id", rideDetailsSearch.getDestinationId()));
        }
    }

    /**
     * Search by operator ids.
     * @param rideDetailsSearch
     * @param criteria
     */
    private void searchOperatorIds(final RideDetailsSearch rideDetailsSearch, Criteria criteria) {
        if (!rideDetailsSearch.getOperatorIds().isEmpty()) {
            criteria.add(Restrictions.in("fareDetails.operator.id", rideDetailsSearch.getOperatorIds()));
        }
    }

    /**
     * Search by type ids.
     * @param rideDetailsSearch
     * @param criteria
     */
    private void searchTypeIds(RideDetailsSearch rideDetailsSearch,
                                 Criteria criteria) {
        if (!rideDetailsSearch.getTypeIds().isEmpty()) {
            criteria.add(Restrictions.in("fareDetails.type.id", rideDetailsSearch.getTypeIds()));
        }
    }
}
