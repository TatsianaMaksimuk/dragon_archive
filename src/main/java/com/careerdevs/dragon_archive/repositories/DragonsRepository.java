package com.careerdevs.dragon_archive.repositories;

import com.careerdevs.dragon_archive.models.Dragon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DragonsRepository extends JpaRepository <Dragon, Integer> {

    Optional<Dragon> findDragonByName(String name);
}
