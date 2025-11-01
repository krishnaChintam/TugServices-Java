package com.ship.services.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.math.BigDecimal;
@Entity
@Table(name = "AdmVessel", schema = "dbo")
public class VesselEntity {
    @Id
    @Column(name = "VesselId")
    private Long vesselId;

    @Column(name = "BranchId")
    private Long branchId;

    @Column(name = "VesselCode")
    private String vesselCode;

    @Column(name = "VesselName")
    private String vesselName;

    @Column(name = "CallSign")
    private String callSign;

    @Column(name = "IMOCode")
    private String imoCode;

    @Column(name = "Remarks")
    private String remarks;

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

    @Column(name = "BargeId")
    private Long bargeId;

    @Column(name = "BuildDate")
    private LocalDateTime buildDate;

    @Column(name = "ValueAmount")
    private BigDecimal valueAmount;

    @Column(name = "CurrencyId")
    private Long currencyId;

    @Column(name = "GRT")
    private String grt;

    @Column(name = "VesselType")
    private String vesselType;

    @Column(name = "Flag")
    private String flag;

    @Column(name = "ARRDraft")
    private String arrDraft;

    @Column(name = "DWT")
    private String dwt;

    @Column(name = "LOA")
    private String loa;

    @Column(name = "NRT")
    private String nrt;

    @Column(name = "VesselTypeId")
    private Long vesselTypeId;

    @Column(name = "PackageId")
    private Integer packageId;

    @Column(name = "IsMotherVessel")
    private Integer isMotherVessel;
    // Default constructor
    public VesselEntity() {
    }

    // Getters and Setters
    public Long getVesselId() {
        return vesselId;
    }

    public void setVesselId(Long vesselId) {
        this.vesselId = vesselId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getVesselCode() {
        return vesselCode;
    }

    public void setVesselCode(String vesselCode) {
        this.vesselCode = vesselCode;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public String getImoCode() {
        return imoCode;
    }

    public void setImoCode(String imoCode) {
        this.imoCode = imoCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMappingCode() {
        return mappingCode;
    }

    public void setMappingCode(String mappingCode) {
        this.mappingCode = mappingCode;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
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

    public Long getBargeId() {
        return bargeId;
    }

    public void setBargeId(Long bargeId) {
        this.bargeId = bargeId;
    }

    public LocalDateTime getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(LocalDateTime buildDate) {
        this.buildDate = buildDate;
    }

    public BigDecimal getValueAmount() {
        return valueAmount;
    }

    public void setValueAmount(BigDecimal valueAmount) {
        this.valueAmount = valueAmount;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getGrt() {
        return grt;
    }

    public void setGrt(String grt) {
        this.grt = grt;
    }

    public String getVesselType() {
        return vesselType;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getArrDraft() {
        return arrDraft;
    }

    public void setArrDraft(String arrDraft) {
        this.arrDraft = arrDraft;
    }

    public String getDwt() {
        return dwt;
    }

    public void setDwt(String dwt) {
        this.dwt = dwt;
    }

    public String getLoa() {
        return loa;
    }

    public void setLoa(String loa) {
        this.loa = loa;
    }

    public String getNrt() {
        return nrt;
    }

    public void setNrt(String nrt) {
        this.nrt = nrt;
    }

    public Long getVesselTypeId() {
        return vesselTypeId;
    }

    public void setVesselTypeId(Long vesselTypeId) {
        this.vesselTypeId = vesselTypeId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Integer getIsMotherVessel() {
        return isMotherVessel;
    }

    public void setIsMotherVessel(Integer isMotherVessel) {
        this.isMotherVessel = isMotherVessel;
    }
}

