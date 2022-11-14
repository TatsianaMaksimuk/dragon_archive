package com.careerdevs.dragon_archive.repositories;

import com.careerdevs.dragon_archive.models.DragonRider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DragonRidersRepository  extends JpaRepository <DragonRider, Integer> {
}
