package com.ship.services.service;

import com.ship.services.model.VesselEntity;
import com.ship.services.repo.VesselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VesselService {
    @Autowired
    private VesselRepository vesselRepository;

    public List<VesselEntity> getAllVessels() {
        return vesselRepository.findAll();
    }
}
