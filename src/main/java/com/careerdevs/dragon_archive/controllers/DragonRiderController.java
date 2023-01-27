package com.careerdevs.dragon_archive.controllers;

import com.careerdevs.dragon_archive.models.Dragon;
import com.careerdevs.dragon_archive.models.DragonRider;
import com.careerdevs.dragon_archive.repositories.DragonRidersRepository;
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
@RequestMapping("/api/riders")
public class DragonRiderController {

    @Autowired
    private DragonsRepository dragonsRepository;

    @Autowired
    private DragonRidersRepository dragonRidersRepository;

    @PostMapping("/")
    public ResponseEntity<?> addOneDragonRiderToDB(@RequestBody DragonRider newRiderData){
        DragonRider addedRider = dragonRidersRepository.save(newRiderData);
        return new ResponseEntity<>(addedRider, HttpStatus.CREATED);
    }


    @PostMapping("{dragonId}")
    public ResponseEntity<?> addDragonRiderTooExistingDragonDB(@RequestBody DragonRider newRiderData, @PathVariable Integer dragonId) {
        //Find Dragon by id
        //return bad request if dragon does not exist
        //if exists - add rider
        Dragon dragon = dragonsRepository.findById(dragonId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        newRiderData.setDragon(dragon);
        DragonRider addedRider = dragonRidersRepository.save(newRiderData);
        return new ResponseEntity<>(addedRider, HttpStatus.CREATED);
    }


//    @PostMapping
//    public ResponseEntity<?> addDragonRiderTooDB(@RequestBody DragonRider newRiderData) {
//        //Find Dragon by id
//        //return bad request if dragon does not exist
//        //if exists - add rider
//
//        DragonRider addedRider = dragonRidersRepository.save(newRiderData);
//        return new ResponseEntity<>(addedRider, HttpStatus.CREATED);
//    }

    @GetMapping("/")
    public ResponseEntity<?> getAllRidersFromDB() {
        List<DragonRider> allRiders = dragonRidersRepository.findAll();
        return new ResponseEntity<>(dragonRidersRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRiderById(@PathVariable Integer id) {
        Optional<DragonRider> requestedRider = dragonRidersRepository.findById(id); //optional is for db (I try to find in db but if I don't optional will have that info (id is null f.e.)
        if (requestedRider.isEmpty()) {
            return new ResponseEntity<>("Dragon Rider not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(requestedRider.get(), HttpStatus.OK);
    }


}
