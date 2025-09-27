package com.ship.services.service;

import com.ship.services.model.TugServiceType;
import com.ship.services.repo.TugServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TugServiceTypeService {

    @Autowired
    private TugServiceTypeRepository tugServiceTypeRepository;

    public List<TugServiceType> getActiveServiceTypes() {
        return tugServiceTypeRepository.findByIsActiveTrue();
    }
}
