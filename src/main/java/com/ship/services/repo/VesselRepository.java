package com.ship.services.repo;

import com.ship.services.model.VesselEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VesselRepository extends JpaRepository<VesselEntity, Long> {
    Optional<VesselEntity> findByVesselNameIgnoreCase(String vesselName);
    @Query("SELECT COALESCE(MAX(v.vesselId), 0) + 1 FROM VesselEntity v")
    Long getNextVesselId();
}