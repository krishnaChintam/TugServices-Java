package com.ship.services.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TugServiceHeader")
public class TugServiceHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ServiceId")
    private Long serviceId;

    @Column(name = "RefNo", nullable = false, unique = true, length = 50)
    private String refNo;

    @Column(name = "ServiceDate", nullable = false)
    private String serviceDate;   // You can use LocalDate if preferred

    @Column(name = "LocationId", nullable = false)
    private Long locationId;

    @Column(name = "LocationName", nullable = false, length = 100)
    private String locationName;

    @Column(name = "VesselId", nullable = true)
    private Long vesselId;

    @Column(name = "VesselName", nullable = false, length = 100)
    private String vesselName;

    @Column(name = "IMOCode", nullable = false, length = 20)
    private String imoCode;

    @Column(name = "VesselType", nullable = false, length = 50)
    private String vesselType;

    @Column(name = "LengthOverall", nullable = false, length = 50)
    private String lengthOverall;

    @Column(name = "DraughtForward", nullable = false, length = 50)
    private String draughtForward;

    @Column(name = "DraughtAft", nullable = false, length = 50)
    private String draughtAft;

    @Column(name = "ServiceType", nullable = false, length = 200)
    private String serviceType;

    @Column(name = "ServiceRemarks", length = 500)
    private String serviceRemarks;

    @Column(name = "Remarks", length = 500)
    private String remarks;

    @Column(name = "IsActive", nullable = false)
    private Integer isActive = 1;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "CreatedDate")
    private LocalDateTime createdDate;

    @Column(name = "EditedBy")
    private String editedBy;

    @Column(name = "EditedDate")
    private LocalDateTime editedDate;

    @OneToMany(mappedBy = "header", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TugServiceActivity> activities;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getVesselId() {
        return vesselId;
    }

    public void setVesselId(Long vesselId) {
        this.vesselId = vesselId;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getImoCode() {
        return imoCode;
    }

    public void setImoCode(String imoCode) {
        this.imoCode = imoCode;
    }

    public String getVesselType() {
        return vesselType;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }

    public String getLengthOverall() {
        return lengthOverall;
    }

    public void setLengthOverall(String lengthOverall) {
        this.lengthOverall = lengthOverall;
    }

    public String getDraughtForward() {
        return draughtForward;
    }

    public void setDraughtForward(String draughtForward) {
        this.draughtForward = draughtForward;
    }

    public String getDraughtAft() {
        return draughtAft;
    }

    public void setDraughtAft(String draughtAft) {
        this.draughtAft = draughtAft;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceRemarks() {
        return serviceRemarks;
    }

    public void setServiceRemarks(String serviceRemarks) {
        this.serviceRemarks = serviceRemarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public List<TugServiceActivity> getActivities() {
        return activities;
    }

    public void setActivities(List<TugServiceActivity> activities) {
        this.activities = activities;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(String editedBy) {
        this.editedBy = editedBy;
    }

    public LocalDateTime getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(LocalDateTime editedDate) {
        this.editedDate = editedDate;
    }
}
