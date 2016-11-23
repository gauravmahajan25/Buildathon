package com.chooseacab.service.impl;

import com.chooseacab.model.RideDetails;
import com.chooseacab.repository.RideDetailsJpaRepository;
import com.chooseacab.search.RideDetailsSearch;
import com.chooseacab.service.RideDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RideDetailsServiceImpl implements RideDetailsService {

    private RideDetailsJpaRepository rideDetailsJpaRepository;

    @Autowired
    public RideDetailsServiceImpl(final RideDetailsJpaRepository rideDetailsJpaRepository) {
        this.rideDetailsJpaRepository = rideDetailsJpaRepository;
    }

    @Override
    public List<RideDetails> searchRideDetails(RideDetailsSearch rideDetailsSearch) {
        return rideDetailsJpaRepository.searchRideDetails(rideDetailsSearch);
    }
}
