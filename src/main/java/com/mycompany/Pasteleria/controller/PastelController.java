/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Pasteleria.controller;

import com.mycompany.Pasteleria.model.Pastel;
import com.mycompany.Pasteleria.repository.PastelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabhs
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class PastelController {

    @Autowired
    private PastelRepository pastelRepository;

    @PostMapping("/pastel")
    public ResponseEntity<Pastel> addPed(@RequestBody Pastel pastel) {
        try {
            Pastel empdo = pastelRepository.save(pastel);
            return new ResponseEntity<>(empdo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/pastel/{id}")
    public ResponseEntity<Void> deleteEmpdoById(@PathVariable("id") Long id) {
        try {
            pastelRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pastel/{id}")
    public ResponseEntity<Pastel> actualizar(@PathVariable("id") long id, @RequestBody Pastel pastel) {
        return pastelRepository.findById(id).map(p -> {
            p.setNombre(pastel.getNombre());
            p.setCosto(pastel.getCosto());
            Pastel updated = pastelRepository.save(p);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pastel")
    public ResponseEntity<List<Pastel>> getAllEmpdos() {
        try {
            List<Pastel> pastel = pastelRepository.findAll();
            if (pastel.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pastel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pastel/{id}")
    public ResponseEntity<Pastel> getEmpdoById(@PathVariable("id") Long id) {
        try {
            Pastel pastel = pastelRepository.findById(id).get();
            return new ResponseEntity<>(pastel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
