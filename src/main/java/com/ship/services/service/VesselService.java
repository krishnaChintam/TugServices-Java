package com.ship.services.service;

import com.ship.services.model.VesselEntity;
import com.ship.services.repo.VesselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VesselService {
    @Autowired
    private VesselRepository vesselRepository;

    public List<VesselEntity> getAllVessels() {

        return vesselRepository.findAll();
    }

    public VesselEntity findByVesselName(String vesselName) {
        Optional<VesselEntity> vesselOpt = vesselRepository.findByVesselNameIgnoreCase(vesselName);
        return vesselOpt.orElse(null);
    }

    public VesselEntity save(VesselEntity vessel) {
        return vesselRepository.save(vessel);
    }
}
