package com.chooseacab.repository.impl;

import com.chooseacab.model.Location;
import com.chooseacab.repository.LocationJpaRepository;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Location Repostory class.
 * 
 */
@Repository
public class LocationAbstractJpaRepositoryImpl extends AbstractJpaRepositoryImpl<Location>
                    implements LocationJpaRepository {

    /**
     * Get All Locations.
     * @return list of locations.
     */
    @Override
    public final List<Location> getAllLocations(){
        Criteria criteria = createCriteria();
        return criteria.list();
    }
}
