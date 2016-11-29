package com.chooseacab.repository.impl;

import com.chooseacab.model.Location;
import com.chooseacab.repository.LocationJpaRepository;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationAbstractJpaRepositoryImpl extends AbstractJpaRepositoryImpl<Location>
                    implements LocationJpaRepository {

    /**
     * @return list of locations.
     */
    @Override
    public final List<Location> getAllLocations(){
        Criteria criteria = createCriteria();
        return criteria.list();
    }
}
