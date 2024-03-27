package andrei.springboot.fotbal_proiect.controller;

import andrei.springboot.fotbal_proiect.entity.Player;
import andrei.springboot.fotbal_proiect.entity.Team;
import andrei.springboot.fotbal_proiect.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api") // TODO: 27.03.2024 La fel ca in PlayerController
public class MyRESTControllerTeam {

    @Autowired
    private TeamService teamService; // TODO: 27.03.2024 La fel ca in PlayerController

    @GetMapping("/teams")// TODO: 27.03.2024 La fel ca in PlayerController
    public List<Team> showAllTeams() {
        List<Team> allTeams = teamService.getAllTeams();// TODO: 27.03.2024 La fel ca in PlayerController
        return allTeams;
    }

    @GetMapping("/teams/{id}")
    public Team getTeam(@PathVariable int id) {
        Team team = teamService.getTeam(id);// TODO: 27.03.2024 La fel ca in PlayerController
        return team;
    }

    @PostMapping("/teams")
    public Team addNewTeam(@RequestBody Team team) {// TODO: 27.03.2024 La fel ca in PlayerController
        teamService.saveTeam(team);
        return team;
    }

    @PutMapping("/teams")
    public Team updateTeam(@RequestBody Team team) {// TODO: 27.03.2024 La fel ca in PlayerController
        teamService.saveTeam(team);
        return team;
    }

    @DeleteMapping("/teams/{id}")
    public String deleteTeam(@PathVariable int id) {
        Team team = teamService.getTeam(id);// TODO: 27.03.2024 La fel ca in PlayerController
        teamService.deleteTeam(id);
        return "Team with ID = " + id + " was deleted.";
    }

    @GetMapping("/teams/name/{teams}")
    public List<Team> showAllPlayersBySpecificTeam(@PathVariable String name) {
        List<Team> teams = teamService.findAllByName(name);
        return teams;
    }
}
