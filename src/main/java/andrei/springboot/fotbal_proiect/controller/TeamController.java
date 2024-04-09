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
    public Team getTeam(@PathVariable Long id) {
        return teamService.getTeam(id);
    }

    @PostMapping
    public ResponseEntity<String> addNewTeam(@RequestBody Team team) {
        try {
            teamService.saveTeam(team);
            return ResponseEntity.ok("Echipa a fost salvată cu succes");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body
                    ("A apărut o eroare la salvarea echipei");
        }
    }

    @PutMapping
    public void updateTeam(@RequestBody Team team) {
        teamService.saveTeam(team);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable Long id) {
        try {
            teamService.deleteTeam(id);
            return ResponseEntity.ok("Echipa cu ID-ul:" + id + " a fost ștearsă.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}