package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.dao.TeamRepository;
import andrei.springboot.fotbal_proiect.entity.Team;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
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

//    @Override
//    public List<Team> findAllByName(String name) {
//        return teamRepository.findAllByName(name);
//    }
}
