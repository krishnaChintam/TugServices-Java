package com.ship.services.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Documents")
public class DocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DocumentId")
    private Long documentId;

    @Column(name = "ServiceId")
    private Long serviceId;

    @Column(name = "FileName")
    private String fileName;

    @Column(name = "FilePath")
    private String filePath;

    @Column(name = "UploadedBy")
    private String uploadedBy;

    @Column(name = "UploadedDate", insertable = false, updatable = false)
    private LocalDateTime uploadedDate;

    // ================== Getters and Setters ==================
    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public LocalDateTime getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(LocalDateTime uploadedDate) {
        this.uploadedDate = uploadedDate;
    }
}
