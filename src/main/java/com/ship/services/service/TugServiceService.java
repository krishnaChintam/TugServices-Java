package com.ship.services.service;

import com.ship.services.model.TugServiceActivity;
import com.ship.services.model.TugServiceHeader;
import com.ship.services.repo.TugServiceHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TugServiceService {
    @Autowired
    private TugServiceHeaderRepository headerRepo;

    @Transactional
    public TugServiceHeader save(TugServiceHeader header) {
        try {
            if (header.getActivities() != null) {
                for (TugServiceActivity act : header.getActivities()) {
                    act.setHeader(header);
                }
            }
            return headerRepo.save(header);
        } catch (Exception ex) {
            throw new RuntimeException("Error saving TugServiceHeader: " + ex.getMessage(), ex);
        }
    }

    @Transactional
    public TugServiceHeader update(Long id, TugServiceHeader newHeader) {
        try {
            return headerRepo.findById(id).map(existing -> {
                existing.setRefNo(newHeader.getRefNo());
                existing.setServiceDate(newHeader.getServiceDate());
                existing.setLocationId(newHeader.getLocationId());
                existing.setLocationName(newHeader.getLocationName());
                existing.setVesselId(newHeader.getVesselId());
                existing.setVesselName(newHeader.getVesselName());
                existing.setImoCode(newHeader.getImoCode());
                existing.setVesselType(newHeader.getVesselType());
                existing.setLengthOverall(newHeader.getLengthOverall());
                existing.setDraughtForward(newHeader.getDraughtForward());
                existing.setDraughtAft(newHeader.getDraughtAft());
                existing.setServiceType(newHeader.getServiceType());
                existing.setServiceRemarks(newHeader.getServiceRemarks());
                existing.setRemarks(newHeader.getRemarks());
                existing.setIsActive(newHeader.getIsActive());
                existing.setTugName(newHeader.getTugName());
                existing.setMotherVessel(newHeader.getMotherVessel());

                existing.getActivities().clear();
                if (newHeader.getActivities() != null) {
                    for (TugServiceActivity act : newHeader.getActivities()) {
                        act.setHeader(existing);
                        existing.getActivities().add(act);
                    }
                }
                return headerRepo.save(existing);
            }).orElseThrow(() -> new RuntimeException("ServiceId " + id + " not found"));
        } catch (Exception ex) {
            throw new RuntimeException("Error updating TugServiceHeader: " + ex.getMessage(), ex);
        }
    }

    public Optional<TugServiceHeader> getById(Long id) {
        try {
            return headerRepo.findById(id);
        } catch (Exception ex) {
            throw new RuntimeException("Error fetching TugServiceHeader by id: " + ex.getMessage(), ex);
        }
    }

    public List<TugServiceHeader> listAll() {
        try {
            return headerRepo.findAll();
        } catch (Exception ex) {
            throw new RuntimeException("Error listing TugServiceHeaders: " + ex.getMessage(), ex);
        }
    }
    public List<TugServiceHeader> getByCreatedUser(String username) {
        try {
            return headerRepo.findByCreatedBy(username);
        } catch (Exception ex) {
            throw new RuntimeException("Error listing TugServiceHeaders: " + ex.getMessage(), ex);
        }
    }
}
