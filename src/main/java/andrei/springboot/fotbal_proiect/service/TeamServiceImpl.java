package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.dao.PlayerRepository;
import andrei.springboot.fotbal_proiect.dao.TeamRepository;
import andrei.springboot.fotbal_proiect.entity.Team;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public TeamServiceImpl(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public void saveTeam(Team team) {
        if (team.getName() == null) {
            throw new IllegalArgumentException("Numele echipei nu poate fi null");
        }
        Team existingTeam = teamRepository.findByName(team.getName());
        if (existingTeam != null) {
            throw new IllegalArgumentException("Există deja o echipă cu același nume în baza de date");
        }
        teamRepository.save(team);
    }

    @Override
    public Team getTeam(int id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Team not found with id: " + id));
    }

    @Override
    public void deleteTeam(int id) {
        // TODO: 03.04.2024 Ce se intampla daca incerci sa stergi o echipa cu un id care nu exista in baza de date ?
        teamRepository.deleteById(id);
    }

    //    @Override
//    public List<Player> getPlayersByTeamId(Long teamId) {
//        Optional<Team> teamOptional = teamRepository.findById(teamId);
//        if (teamOptional.isPresent()) {
//            Team team = teamOptional.get();
//            return team.getPlayers();
//        } else {
//            return null; // TODO: 03.04.2024 In loc sa returnezi null in cadrul colectiilor este indicat sa returnezi o colectie goala cu 0 elemente
//        }
//    }
}
