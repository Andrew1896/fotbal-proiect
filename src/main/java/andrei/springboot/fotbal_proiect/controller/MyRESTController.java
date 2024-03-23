package andrei.springboot.fotbal_proiect.controller;

import andrei.springboot.fotbal_proiect.entity.Player;
import andrei.springboot.fotbal_proiect.entity.Team;
import andrei.springboot.fotbal_proiect.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/teams")
    public List<Team> showAllTeams() {
        List<Team> allEmployees = teamService.getAllTeams();
        return allEmployees;
    }

    @GetMapping("/teams/{id}")
    public Team getEmployee(@PathVariable int id) {
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

    @GetMapping("/teams/{teamId}/players")
    public List<Player> showAllPlayersBySpecificTeam (@PathVariable String team) {
        List<Player> players = teamService.findAllByName(team);
        return players;
    }
}
