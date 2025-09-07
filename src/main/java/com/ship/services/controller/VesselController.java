package com.ship.services.controller;


import com.ship.services.model.VesselEntity;
import com.ship.services.service.VesselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vessels")
public class VesselController {
    @Autowired
    private VesselService vesselService;

    @GetMapping("/all")
    public List<VesselEntity> getAllVessels() {
        return vesselService.getAllVessels();
    }
}
