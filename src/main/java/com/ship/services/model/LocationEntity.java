package com.ship.services.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AdmLocation", schema = "dbo")
public class LocationEntity {

    @Id
    @Column(name = "LocationId")
    private Long locationId;

    @Column(name = "BranchId")
    private Long branchId;

    @Column(name = "PortId")
    private Long portId;

    @Column(name = "LocationCode")
    private String locationCode;

    @Column(name = "LocationName")
    private String locationName;

    @Column(name = "IsPort")
    private Boolean isPort;

    @Column(name = "IsTerminal")
    private Boolean isTerminal;

    @Column(name = "IsBerth")
    private Boolean isBerth;

    @Column(name = "IsArea")
    private Boolean isArea;

    @Column(name = "MappingCode")
    private String mappingCode;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Column(name = "CreateBy")
    private String createBy;

    @Column(name = "CreateDate")
    private LocalDateTime createDate;

    @Column(name = "EditBy")
    private String editBy;

    @Column(name = "EditDate")
    private LocalDateTime editDate;

    @Column(name = "LocationOwner")
    private String locationOwner;

    @Column(name = "LocationOwnerVAT")
    private String locationOwnerVAT;

    @Column(name = "LocationNumber")
    private String locationNumber;

    @Column(name = "LocationOwnerExcise")
    private String locationOwnerExcise;

    public LocationEntity() {
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getPortId() {
        return portId;
    }

    public void setPortId(Long portId) {
        this.portId = portId;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public Boolean getPort() {
        return isPort;
    }

    public void setPort(Boolean port) {
        isPort = port;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Boolean getTerminal() {
        return isTerminal;
    }

    public void setTerminal(Boolean terminal) {
        isTerminal = terminal;
    }

    public Boolean getArea() {
        return isArea;
    }

    public void setArea(Boolean area) {
        isArea = area;
    }

    public Boolean getBerth() {
        return isBerth;
    }

    public void setBerth(Boolean berth) {
        isBerth = berth;
    }

    public String getMappingCode() {
        return mappingCode;
    }

    public void setMappingCode(String mappingCode) {
        this.mappingCode = mappingCode;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }

    public LocalDateTime getEditDate() {
        return editDate;
    }

    public void setEditDate(LocalDateTime editDate) {
        this.editDate = editDate;
    }

    public String getLocationOwner() {
        return locationOwner;
    }

    public void setLocationOwner(String locationOwner) {
        this.locationOwner = locationOwner;
    }

    public String getLocationOwnerVAT() {
        return locationOwnerVAT;
    }

    public void setLocationOwnerVAT(String locationOwnerVAT) {
        this.locationOwnerVAT = locationOwnerVAT;
    }

    public String getLocationNumber() {
        return locationNumber;
    }

    public void setLocationNumber(String locationNumber) {
        this.locationNumber = locationNumber;
    }

    public String getLocationOwnerExcise() {
        return locationOwnerExcise;
    }

    public void setLocationOwnerExcise(String locationOwnerExcise) {
        this.locationOwnerExcise = locationOwnerExcise;
    }
}
