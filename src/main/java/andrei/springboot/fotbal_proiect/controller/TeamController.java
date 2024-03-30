package andrei.springboot.fotbal_proiect.controller;

import andrei.springboot.fotbal_proiect.entity.Player;
import andrei.springboot.fotbal_proiect.entity.Team;
import andrei.springboot.fotbal_proiect.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> showAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable int id) {
        return teamService.getTeam(id);
    }

    @PostMapping
    public void addNewTeam(@RequestBody Team team) {
        teamService.saveTeam(team);
    }

    @PutMapping
    public void updateTeam(@RequestBody Team team) {
        teamService.saveTeam(team);
    }

    @DeleteMapping("/{id}")
    public String deleteTeam(@PathVariable int id) {
        teamService.deleteTeam(id);
        return "Team with ID = " + id + " was deleted.";
    }

    public ResponseEntity<List<Player>> getPlayersByTeamId(@PathVariable Long teamId) {
        List<Player> players = teamService.getPlayersByTeamId(teamId);
        if (players != null && !players.isEmpty()) {
            return new ResponseEntity<>(players, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}