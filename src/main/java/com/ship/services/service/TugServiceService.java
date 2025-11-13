package com.ship.services.service;

import com.ship.services.exception.DuplicateRefNoException;
import com.ship.services.model.TugServiceActivity;
import com.ship.services.model.TugServiceHeader;
import com.ship.services.model.VesselEntity;
import com.ship.services.repo.TugServiceHeaderRepository;
import com.ship.services.repo.VesselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TugServiceService {
    @Autowired
    private TugServiceHeaderRepository headerRepo;

    @Autowired
    private VesselService vesselService;

    @Autowired
    private VesselRepository vesselRepository;

    @Transactional
    public TugServiceHeader save(TugServiceHeader header) {
        try {

            // Check if record already exists
            Optional<TugServiceHeader> existing = headerRepo.findByRefNo(header.getRefNo());

            if (existing.isPresent()) {
                throw new DuplicateRefNoException("Record already exists with RefNo: " + header.getRefNo());
            }

            // Check if vessel exists
            VesselEntity existingVessel = vesselService.findByVesselName(header.getVesselName());
            // If not found, create a new record in AdmVessel
            if (existingVessel == null && header.getVesselName() != null && !header.getVesselName().trim().isEmpty()) {
                VesselEntity newVessel = new VesselEntity();
                newVessel.setVesselName(header.getVesselName());
                newVessel.setVesselId(vesselRepository.getNextVesselId());
                newVessel.setImoCode(header.getImoCode());
                newVessel.setVesselType(header.getVesselType());
                newVessel.setVesselCode(header.getVesselName());
                newVessel.setLoa(header.getLengthOverall());
                newVessel.setBranchId(1L);
                newVessel.setIsMotherVessel(0);
                newVessel.setBargeId(1L);
                newVessel.setArrDraft("");
                newVessel.setCallSign("");
                newVessel.setDwt("");
                newVessel.setFlag("");
                newVessel.setGrt("");
                newVessel.setMappingCode("");
                newVessel.setNrt("");
                newVessel.setRemarks("");
                newVessel.setVesselTypeId(1L);
                newVessel.setBuildDate(LocalDateTime.now());
                newVessel.setValueAmount(BigDecimal.ZERO);
                newVessel.setCurrencyId(1L);
                newVessel.setPackageId(0);
                newVessel.setIsActive(true);
                newVessel.setCreateDate(LocalDateTime.now());
                newVessel.setCreateBy("System");
                newVessel.setEditBy("System");
                newVessel.setEditDate(LocalDateTime.now());
                vesselService.save(newVessel);
            }
            if (header.getActivities() != null) {
                for (TugServiceActivity act : header.getActivities()) {
                    act.setHeader(header);
                }
            }
            return headerRepo.save(header);
        } catch (DuplicateRefNoException ex) {
            throw ex;
        }catch (Exception ex) {
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
                existing.setPairWith(newHeader.getPairWith());
                existing.setCommandRankAndName(newHeader.getCommandRankAndName());

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
    public List<TugServiceHeader> getByDateRange(String fromDate, String toDate) {
        try {
            return headerRepo.findByServiceDateBetween(fromDate, toDate);
        } catch (Exception ex) {
            throw new RuntimeException("Error fetching TugServiceHeaders by date range: " + ex.getMessage(), ex);
        }
    }
    public List<TugServiceHeader> getByUsernameAndDateRange(String username, String fromDate, String toDate) {
        try {
            return headerRepo.findByCreatedByAndServiceDateBetween(username, fromDate, toDate);
        } catch (Exception ex) {
            throw new RuntimeException("Error fetching TugServiceHeaders by user and date range: " + ex.getMessage(), ex);
        }
    }

}
