package com.ship.services.repo;

import com.ship.services.model.TugServiceHeader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TugServiceHeaderRepository extends JpaRepository<TugServiceHeader, Long> {
    List<TugServiceHeader> findByCreatedBy(String createBy);
}
