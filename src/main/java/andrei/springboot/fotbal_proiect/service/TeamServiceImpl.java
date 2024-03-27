package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.dao.TeamRepository;
import andrei.springboot.fotbal_proiect.entity.Player;  // TODO: 27.03.2024 Ai grija sa stergi importurile redundante
import andrei.springboot.fotbal_proiect.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    // TODO: 27.03.2024 Formateaza codul in pagina: CTRL + ALT + L ar trebui sa fie
@Autowired
private TeamRepository teamRepository; // TODO: 27.03.2024 E de indicata injectarea prin constructor in loc de  @Autowired

@Override
public List<Team> getAllTeams() {
        return teamRepository.findAll();
        }

@Override
public void saveTeam(Team team) {
        teamRepository.save(team);
        }

@Override
public Team getTeam(int id) { // TODO: 27.03.2024 Optional este pentru a scapa de null, intreaba pe CHAT-GPT cum poti sa imbunatatesti acest cod cu orElseThrow()
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
    public List<Team> findAllByName(String name) {
        List<Team> teams = teamRepository.findAllByName(name); // TODO: 27.03.2024 Intr-o singura linie
        return teams;
        }
}
