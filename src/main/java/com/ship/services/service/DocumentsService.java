package com.ship.services.service;

import com.ship.services.model.DocumentEntity;
import com.ship.services.repo.DocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentsService {
    @Autowired
    private DocumentsRepository documentRepository;

    @Value("${file.upload.base-dir}")
    private String BASE_DIR;


    // LIST DOCUMENTS BY SERVICE ID

    public List<DocumentEntity> getDocumentsByServiceId(Long serviceId) {
        return documentRepository.findByServiceIdOrderByUploadedDateDesc(serviceId);
    }
    // DOWNLOAD DOCUMENT

    public File downloadDocument(Long documentId) {
        Optional<DocumentEntity> optionalDoc = documentRepository.findById(documentId);
        if (optionalDoc.isEmpty()) return null;

        DocumentEntity doc = optionalDoc.get();
        File file = new File(doc.getFilePath());
        return file.exists() ? file : null;
    }
    // DELETE DOCUMENT

    public boolean deleteDocument(Long documentId) {
        Optional<DocumentEntity> optionalDoc = documentRepository.findById(documentId);
        if (optionalDoc.isEmpty()) return false;

        DocumentEntity doc = optionalDoc.get();
        File file = new File(doc.getFilePath());
        if (file.exists()) file.delete();

        documentRepository.deleteById(documentId);
        return true;
    }
    // UPLOAD DOCUMENT (Replaces existing file if same name exists)
    public List<DocumentEntity> uploadMultipleDocuments(MultipartFile[] files, Long serviceId, String uploadedBy) throws IOException {
        List<DocumentEntity> uploadedDocs = new ArrayList<>();

        // Make sure directory exists
        String uploadDir = getDynamicUploadPath();
        Files.createDirectories(Paths.get(uploadDir));

        // Get existing documents for this service (to check duplicates)
        List<DocumentEntity> existingDocs = documentRepository.findByServiceIdOrderByUploadedDateDesc(serviceId);

        for (MultipartFile file : files) {
            // Check if this file already exists for the same service
            for (DocumentEntity existing : existingDocs) {
                if (existing.getFileName().equalsIgnoreCase(file.getOriginalFilename())) {
                    // Delete old file from disk
                    File oldFile = new File(existing.getFilePath());
                    if (oldFile.exists()) oldFile.delete();

                    // Delete old DB record
                    documentRepository.deleteById(existing.getDocumentId());
                }
            }

            // Save new file with unique name
            String uniqueFileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, uniqueFileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Create new DB record
            DocumentEntity doc = new DocumentEntity();
            doc.setServiceId(serviceId);
            doc.setFileName(file.getOriginalFilename());
            doc.setFilePath(filePath.toString().replace("\\", "/"));
            doc.setUploadedBy(uploadedBy);
            doc.setUploadedDate(LocalDateTime.now());

            // Save and add to list
            uploadedDocs.add(documentRepository.save(doc));
        }

        return uploadedDocs;
    }

    // Helper: Folder Structure (D:/Test/YYYY/MON/YYYYMMDD)
    private String getDynamicUploadPath() {
        LocalDate now = LocalDate.now();
        String year = String.valueOf(now.getYear());
        String monthName = now.getMonth().toString().substring(0, 3); // JAN, FEB, etc.
        String dateFolder = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return String.format("%s/%s/%s/%s", BASE_DIR, year, monthName, dateFolder);
    }
}
