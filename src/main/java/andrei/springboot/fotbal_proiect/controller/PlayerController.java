package andrei.springboot.fotbal_proiect.controller;

import andrei.springboot.fotbal_proiect.entity.Player;
import andrei.springboot.fotbal_proiect.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> showAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable Long id) {
        return playerService.getPlayer(id);
    }

    @PostMapping
    public void addNewPlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
    }

    @PutMapping
    public void updatePlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return "Player with ID = " + id + " was deleted.";
    }

    @GetMapping("/{teamId}/players")
    public ResponseEntity<List<Player>> getPlayersByTeamId(@PathVariable Long teamId) {
        List<Player> players = playerService.getPlayersByTeamId(teamId);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
}


