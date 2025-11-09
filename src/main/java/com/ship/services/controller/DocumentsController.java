package com.ship.services.controller;

import com.ship.services.model.DocumentEntity;
import com.ship.services.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentsController {
    @Autowired
    private DocumentsService documentService;

    // UPLOAD FILE (Replaces old file if same name for same screen)
    @PostMapping("/upload")
    public ResponseEntity<?> uploadDocuments(
            @RequestParam("documents") MultipartFile[] files,
            @RequestParam("serviceId") Long serviceId,
            @RequestParam("uploadedBy") String uploadedBy) {
        try {
            List<DocumentEntity> savedDocs = documentService.uploadMultipleDocuments(files, serviceId, uploadedBy);
            return ResponseEntity.ok(savedDocs);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Upload failed: " + e.getMessage());
        }
    }


    //GET LIST OF FILES BY SERVICE ID
    @GetMapping("/{serviceId}")
    public ResponseEntity<List<DocumentEntity>> getDocuments(@PathVariable Long serviceId) {
        List<DocumentEntity> docs = documentService.getDocumentsByServiceId(serviceId);
        return ResponseEntity.ok(docs);
    }

    // DOWNLOAD FILE BY DOCUMENT ID
    @GetMapping("/download/{documentId}")
    public ResponseEntity<?> downloadDocument(@PathVariable Long documentId) {
        File file = documentService.downloadDocument(documentId);
        if (file == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found");
        }

        FileSystemResource resource = new FileSystemResource(file);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }


    //DELETE FILE BY DOCUMENT ID
    @DeleteMapping("delete/{documentId}")
    public ResponseEntity<?> deleteDocument(@PathVariable Long documentId) {
        boolean deleted = documentService.deleteDocument(documentId);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found");
        }
        return ResponseEntity.ok("Document deleted successfully");
    }
}
