package com.ucl.ucl_champs.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; // makes sure the class is jpa entity
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_stats") // table from the db
public class Player {
    @Id // making the name as primary key
    @Column(name = "player_name", unique = true) // search in  col using player_name
    private String name;
    private String club;
    private Integer goals;
    private Integer assists;
    private Integer appearances;

    public Player() {
    }
    // all in constructor
    public Player(String name, String club, Integer goals, Integer assists, Integer appearances) {
        this.name = name;
        this.club = club;
        this.goals = goals;
        this.assists = assists;
        this.appearances = appearances;
    }

    // using getter and setter to use get and set function
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getAppearances() {
        return appearances;
    }

    public void setAppearances(Integer appearances) {
        this.appearances = appearances;
    }
}
