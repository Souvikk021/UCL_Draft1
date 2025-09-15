package com.ucl.ucl_champs.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component // this refers, its lifecycle wil be managed by spring container
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired // inject this rep to service and enable to interact with db
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByClub(String club) {
        return playerRepository.findAll().stream().filter( player -> club.equals(player.getClub())).collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String searchText) {
        return playerRepository.findAll().stream().filter( player -> player.getName().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
    }

    @Transactional // maintains the data integrity during the deletion
    public void deletePlayer(String playerName) {
        playerRepository.deleteById(playerName);
    }


    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }
}
