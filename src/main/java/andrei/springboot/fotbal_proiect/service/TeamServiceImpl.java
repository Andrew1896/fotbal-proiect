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
    public Team getTeam(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Echipa cu ID-ul: " + id + " nu a fost găsită"));
    }

    @Override
    public void deleteTeam(Long id) {
        if (!teamRepository.existsById(id)) {
            throw new IllegalArgumentException("Echipa cu ID-ul dat nu există în baza de date");
        }
        teamRepository.deleteById(id);
    }
}
