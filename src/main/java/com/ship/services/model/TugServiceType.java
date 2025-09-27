package com.ship.services.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TugServiceType")
public class TugServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ServiceTypeId")
    private Long serviceTypeId;

    @Column(name = "ServiceTypeName", nullable = false, unique = true, length = 100)
    private String serviceTypeName;

    @Column(name = "IsActive", nullable = false)
    private Boolean isActive = true;

    // Getters and setters
    public Long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
