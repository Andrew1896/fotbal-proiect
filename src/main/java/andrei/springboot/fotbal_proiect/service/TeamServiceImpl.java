package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.dao.PlayerRepository;
import andrei.springboot.fotbal_proiect.dao.TeamRepository;
import andrei.springboot.fotbal_proiect.entity.Player;
import andrei.springboot.fotbal_proiect.entity.Team;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        teamRepository.save(team);
    }

    @Override
    public Team getTeam(int id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Team not found with id: " + id));
    }

    @Override
    public void deleteTeam(int id) {
        teamRepository.deleteById(id);
    }

    @Override
    public List<Player> getPlayersByTeamId(Long teamId) {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            return team.getPlayers();
        } else {
            return null;
        }
    }
}
