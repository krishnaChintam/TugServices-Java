package com.ship.services.repo;

import com.ship.services.model.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentsRepository extends JpaRepository<DocumentEntity, Long> {
    List<DocumentEntity> findByServiceIdOrderByUploadedDateDesc(Long serviceId);
}
