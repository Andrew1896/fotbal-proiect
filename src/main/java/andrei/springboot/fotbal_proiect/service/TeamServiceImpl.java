package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.dao.TeamRepository;
import andrei.springboot.fotbal_proiect.entity.Player;
import andrei.springboot.fotbal_proiect.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

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
        Team team = null;
        Optional<Team> optional = teamRepository.findById(id);
        if (optional.isPresent()) {
            team = optional.get();
        }
        return team;
    }

    @Override
    public void deleteTeam(int id) {
        teamRepository.deleteById(id);
    }

    @Override
    public List<Player> findAllByName(String team) {
        List<Player> players = teamRepository.findAllByName(team);
        return null;
    }
}
