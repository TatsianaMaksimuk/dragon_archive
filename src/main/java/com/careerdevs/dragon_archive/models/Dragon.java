package com.careerdevs.dragon_archive.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dragon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String alias;
    private String sex;
    private String appearance;
    private boolean isAlive;
    private String dateOfBirth;
    private String placeOfBirth;
    private String dateOfDeath;
    private String placeOfDeath;

}
