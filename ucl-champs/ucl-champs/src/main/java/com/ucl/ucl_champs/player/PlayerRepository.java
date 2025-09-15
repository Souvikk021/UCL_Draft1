package com.ucl.ucl_champs.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> { // allows crud operation , player -> entity type , string -> primary key
    void deleteByName(String playerName); // delete player by name
    Optional<Player> findByName(String name); // finding player by names and optional refers to player might not be in our repository
}
