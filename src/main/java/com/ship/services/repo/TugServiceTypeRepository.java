package com.ship.services.repo;

import com.ship.services.model.TugServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TugServiceTypeRepository extends JpaRepository<TugServiceType, Long> {
    List<TugServiceType> findByIsActiveTrue();
}
