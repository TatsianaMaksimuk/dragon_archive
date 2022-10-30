package com.careerdevs.dragon_archive.repositories;

import com.careerdevs.dragon_archive.models.Dragon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DragonsRepository extends JpaRepository <Dragon, Integer> {

}
