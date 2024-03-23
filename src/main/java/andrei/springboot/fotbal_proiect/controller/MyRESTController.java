package andrei.springboot.fotbal_proiect.controller;

import andrei.springboot.fotbal_proiect.entity.Player;
import andrei.springboot.fotbal_proiect.entity.Team;
import andrei.springboot.fotbal_proiect.service.PlayerService;
import andrei.springboot.fotbal_proiect.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    private TeamService teamService;

    @GetMapping("/teams")
    public List<Team> showAllTeams() {
        List<Team> allTeams = teamService.getAllTeams();
        return allTeams;
    }

    @GetMapping("/teams/{id}")
    public Team getTeam(@PathVariable int id) {
        Team team = teamService.getTeam(id);
        return team;
    }

    @PostMapping("/teams")
    public Team addNewTeam(@RequestBody Team team) {
        teamService.saveTeam(team);
        return team;
    }

    @PutMapping("/teams")
    public Team updateTeam(@RequestBody Team team) {
        teamService.saveTeam(team);
        return team;
    }

    @DeleteMapping("/teams/{id}")
    public String deleteTeam(@PathVariable int id) {
        Team team = teamService.getTeam(id);
        teamService.deleteTeam(id);
        return "Team with ID = " + id + " was deleted.";
    }

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
    @GetMapping("/teams/{teamId}/players")
    public List<Player> showAllPlayersBySpecificTeam (@PathVariable String team) {
        List<Player> players = teamService.findAllByName(team);
        return players;
    }
}
