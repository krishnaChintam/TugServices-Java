package com.ship.services.controller;

import com.ship.services.model.LocationEntity;
import com.ship.services.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private  LocationService locationService;


    @GetMapping("/all")
    public List<LocationEntity> getAllLocations() {
        return locationService.getAllLocations();
    }
}
