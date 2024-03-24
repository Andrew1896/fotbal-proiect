package andrei.springboot.fotbal_proiect.controller;

import andrei.springboot.fotbal_proiect.entity.Player;
import andrei.springboot.fotbal_proiect.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTControllerPlayer {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public List<Player> showAllPlayers() {
        List<Player> allPlayers = playerService.getAllPlayers();
        return allPlayers;
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id) {
        Player player = playerService.getPlayer(id);
        return player;
    }

    @PostMapping("/players")
    public Player addNewPlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
        return player;
    }

    @PutMapping("/players")
    public Player updatePlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
        return player;
    }

    @DeleteMapping("/players/{id}")
    public String deletePlayer(@PathVariable int id) {
        Player player = playerService.getPlayer(id);
        playerService.deletePlayer(id);
        return "Player with ID = " + id + " was deleted.";
    }

//    @GetMapping("/players/name/players}")
//    public List<Player> showAllPlayersBySpecificTeam(@PathVariable String name) {
//        List<Player> players = playerService.findAllByName(name);
//        return players;
//    }
}
