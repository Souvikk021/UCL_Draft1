package com.ucl.ucl_champs.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController { // manages https request

    private final PlayerService playerService;

    @Autowired // delegate the business logic back to the service layer
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @GetMapping // mapping the get requests
    public List<Player> getPlayers(
        @RequestParam(required = false) String club,
        @RequestParam(required = false) String name){
        if(name != null){
            return playerService.getPlayersByName(name);
        }
        else if(club != null){
            return playerService.getPlayersByClub(club);
        }
        else{
            return playerService.getPlayers();
        }
    }
    @PostMapping // handles https post request to add a player in db, like adding new players
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }







}
