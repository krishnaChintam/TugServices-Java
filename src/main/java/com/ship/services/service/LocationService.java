package com.ship.services.service;

import com.ship.services.model.LocationEntity;
import com.ship.services.repo.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private  LocationRepository locationRepository;

    public List<LocationEntity> getAllLocations() {
        return locationRepository.findAll();
    }
}
