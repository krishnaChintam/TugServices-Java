package com.ship.services.controller;

import com.ship.services.model.TugServiceType;
import com.ship.services.service.TugServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-types")
public class TugServiceTypeController {
    @Autowired
    private TugServiceTypeService tugServiceTypeService;

    @GetMapping("/getAll")
    public List<TugServiceType> getServiceTypes() {
        return tugServiceTypeService.getActiveServiceTypes();
    }
}
