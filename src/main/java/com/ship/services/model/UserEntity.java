package com.ship.services.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "AdmUser",schema = "dbo")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordHash;
    @Column(updatable = false)
    private String createBy;
    @Column(updatable = false)
    private LocalDateTime createDate;
    private String role;
    private String tugName;
    @Column(name = "IsActive", nullable = false)
    private Integer isActive = 1;
    @Column(name = "EditedBy",insertable = false)
    private String editedBy;

    @Column(name = "EditedDate",insertable = false)
    private LocalDateTime editedDate;

    @Column(name = "NoOfHours")
    private Integer noOfHours = 0;

    @Column(name = "PackageCost")
    private BigDecimal packageCost;

    @Column(name = "PerHourCost")
    private BigDecimal perHourCost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTugName() {
        return tugName;
    }

    public void setTugName(String tugName) {
        this.tugName = tugName;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
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

    public Integer getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(Integer noOfHours) {
        this.noOfHours = noOfHours;
    }

    public BigDecimal getPackageCost() {
        return packageCost;
    }

    public void setPackageCost(BigDecimal packageCost) {
        this.packageCost = packageCost;
    }

    public BigDecimal getPerHourCost() {
        return perHourCost;
    }

    public void setPerHourCost(BigDecimal perHourCost) {
        this.perHourCost = perHourCost;
    }
}
