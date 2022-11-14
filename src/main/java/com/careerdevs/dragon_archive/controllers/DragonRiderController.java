package com.careerdevs.dragon_archive.controllers;

import com.careerdevs.dragon_archive.models.DragonRider;
import com.careerdevs.dragon_archive.repositories.DragonRidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/riders")
public class DragonRiderController {

    @Autowired
    private DragonRidersRepository dragonRidersRepository;

    @PostMapping
    public ResponseEntity<?> addDragonRiderTooDB(@RequestBody DragonRider newRiderData){
        DragonRider addedRider = dragonRidersRepository.save(newRiderData);
        return new ResponseEntity<>(addedRider, HttpStatus.CREATED);
    }
}
