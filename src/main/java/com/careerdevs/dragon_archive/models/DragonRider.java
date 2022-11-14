package com.careerdevs.dragon_archive.models;

import javax.persistence.*;

@Entity
public class DragonRider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String house;
    private String culture;
    private String dateOfBirth;
    private String placeOfBirth;
    private boolean isAlive;
    private String dateOfDeath;


    public DragonRider() {

    }


    public DragonRider(String name, String house, String culture, String dateOfBirth, Boolean isAlive, String placeOfBirth, String dateOfDeath) {
        this.name = name;
        this.house = house;
        this.culture = culture;
        this.dateOfBirth = dateOfBirth;
        this.isAlive = isAlive;
        this.placeOfBirth = placeOfBirth;
        this.dateOfDeath = dateOfDeath;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHouse() {
        return house;
    }

    public String getCulture() {
        return culture;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }


}
