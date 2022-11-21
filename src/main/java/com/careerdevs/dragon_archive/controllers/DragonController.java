package com.careerdevs.dragon_archive.controllers;


import com.careerdevs.dragon_archive.models.Dragon;
import com.careerdevs.dragon_archive.repositories.DragonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/dragons")
public class DragonController {

    @Autowired
    private DragonsRepository dragonsRepository;


    @PostMapping
    public ResponseEntity<?> addOneDragonToDB(@RequestBody Dragon newDragonData) {
        try {
            Dragon addedDragon = dragonsRepository.save(newDragonData);
            return new ResponseEntity<>(addedDragon, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllDragonsFromDB() { //ResponseEntity is for communication between server and client, I want to return dragon but not sure if it's gonna be dragon or list of dragons or exception message
        List<Dragon> allDragons = dragonsRepository.findAll();
        return new ResponseEntity<>(dragonsRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDragonById(@PathVariable Integer id) {
        Optional<Dragon> requestedDragon = dragonsRepository.findById(id); //optional is for db (I try to find in db but if I don't optional will have that info (id is null f.e.)
        if (requestedDragon.isEmpty()) {
            return new ResponseEntity<>("Dragon not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(requestedDragon.get(), HttpStatus.OK);
    }


    //update
    @PostMapping("/{id}")
    public ResponseEntity<?> postOneDragonById(@PathVariable Integer id, @RequestBody Dragon newDragonData) {
        Dragon requestedDragon = dragonsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!newDragonData.getName().equals("")) {
            requestedDragon.setName(newDragonData.getName());
        }
        if (!newDragonData.getAlias().equals("")) {
            requestedDragon.setAlias(newDragonData.getAlias());
        }
        if (!newDragonData.getSex().equals("")) {
            requestedDragon.setSex(newDragonData.getSex());
        }
        if (!newDragonData.getAppearance().equals("")) {
            requestedDragon.setAppearance(newDragonData.getAppearance());
        }
        if (newDragonData.getIsAlive() != requestedDragon.getIsAlive()) {
            requestedDragon.setIsAlive(newDragonData.getIsAlive()); ///??
        }
        if (!newDragonData.getDateOfBirth().equals("")) {
            requestedDragon.setDateOfBirth(newDragonData.getDateOfBirth());
        }
        if (!newDragonData.getPlaceOfBirth().equals("")) {
            requestedDragon.setPlaceOfBirth(newDragonData.getPlaceOfBirth());
        }
        if (!newDragonData.getDateOfDeath().equals("")) {
            requestedDragon.setDateOfDeath(newDragonData.getDateOfDeath());
        }
        if (!newDragonData.getPlaceOfDeath().equals("")) {
            requestedDragon.setPlaceOfDeath(newDragonData.getPlaceOfDeath());
        }
        return ResponseEntity.ok(dragonsRepository.save(requestedDragon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDragonById(@PathVariable Integer id) {
        Dragon requestedDragon = dragonsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        dragonsRepository.deleteById(id);
        return ResponseEntity.ok(requestedDragon);
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<?> findDragonByName(@PathVariable String name) {
        Dragon requestedDragon = dragonsRepository.findDragonByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(requestedDragon, HttpStatus.OK);
    }

}
