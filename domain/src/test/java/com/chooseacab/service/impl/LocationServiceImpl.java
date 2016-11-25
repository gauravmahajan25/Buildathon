package com.chooseacab.service.impl;

import com.chooseacab.model.Location;
import com.chooseacab.repository.LocationJpaRepository;
import com.chooseacab.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

    private LocationJpaRepository locationJpaRepository;

    @Autowired
    public LocationServiceImpl(final LocationJpaRepository locationJpaRepository) {
        this.locationJpaRepository = locationJpaRepository;
    }

    @Override
    public List<Location> getAllLocations(){
        return locationJpaRepository.getAllLocations();
    }
}
