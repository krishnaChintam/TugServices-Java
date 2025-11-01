package com.ship.services.repo;

import com.ship.services.model.TugServiceHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TugServiceHeaderRepository extends JpaRepository<TugServiceHeader, Long> {
    List<TugServiceHeader> findByCreatedBy(String createBy);

    @Query("SELECT t FROM TugServiceHeader t " +
            "WHERE t.serviceDate BETWEEN :fromDate AND :toDate " +
            "ORDER BY t.serviceDate DESC")
    List<TugServiceHeader> findByServiceDateBetween(
            @Param("fromDate") String fromDate,
            @Param("toDate") String toDate);

    @Query("SELECT t FROM TugServiceHeader t " +
            "WHERE t.createdBy = :username " +
            "AND t.serviceDate BETWEEN :fromDate AND :toDate " +
            "ORDER BY t.serviceDate DESC")
    List<TugServiceHeader> findByCreatedByAndServiceDateBetween(
            @Param("username") String username,
            @Param("fromDate") String fromDate,
            @Param("toDate") String toDate);

}
