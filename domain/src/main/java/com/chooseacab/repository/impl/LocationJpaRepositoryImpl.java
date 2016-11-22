package com.chooseacab.repository.impl;

import com.chooseacab.model.Location;
import com.chooseacab.repository.LocationJpaRepository;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationJpaRepositoryImpl extends JpaRepositoryImpl<Location>
                    implements LocationJpaRepository {

    @Override
    public List<Location> getAllLocations(){
        Criteria criteria = createCriteria();

        List<Location> locations = criteria.list();

        return locations;
    }
}
