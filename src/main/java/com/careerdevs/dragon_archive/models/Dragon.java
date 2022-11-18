package com.careerdevs.dragon_archive.models;


import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dragon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String alias;
    private String sex;
    private String appearance;
    private boolean isAlive;
    private String dateOfBirth;
    private String placeOfBirth;
    private String dateOfDeath;
    private String placeOfDeath;


    @OneToMany(mappedBy = "dragon", fetch = FetchType.LAZY)
    @JsonIncludeProperties({"name", "house"})
    private List<DragonRider> dragonRider;


    public Dragon() {

    }

    public Dragon(String name, String alias, String sex, String appearance, boolean isAlive, String dateOfBirth, String placeOfBirth, String dateOfDeath, String placeOfDeath) {
        this.name = name;
        this.alias = alias;
        this.sex = sex;
        this.appearance = appearance;
        this.isAlive = isAlive;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.placeOfDeath = placeOfDeath;
    }


    public List<DragonRider> getDragonRider() {
        return dragonRider;
    }


    //getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public String getSex() {
        return sex;
    }

    public String getAppearance() {
        return appearance;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    //Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }

    public void setDragonRider(List<DragonRider> dragonRider) {
        this.dragonRider = dragonRider;
    }

}
