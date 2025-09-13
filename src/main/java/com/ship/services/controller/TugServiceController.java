package com.ship.services.controller;

import com.ship.services.model.TugServiceHeader;
import com.ship.services.service.TugServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tug-services")
public class TugServiceController {
    @Autowired
    private TugServiceService service;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody TugServiceHeader header) {
        try {
            return ResponseEntity.ok(service.save(header));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error saving TugServiceHeader: " + ex.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TugServiceHeader header) {
        try {
            return ResponseEntity.ok(service.update(id, header));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error updating TugServiceHeader: " + ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return service.getById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error fetching TugServiceHeader: " + ex.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> listAll() {
        try {
            List<TugServiceHeader> list = service.listAll();
            return ResponseEntity.ok(list);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error listing TugServiceHeaders: " + ex.getMessage());
        }
    }
}
