package com.ship.services.repo;

import com.ship.services.model.VesselEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VesselRepository extends JpaRepository<VesselEntity, Long> {
}