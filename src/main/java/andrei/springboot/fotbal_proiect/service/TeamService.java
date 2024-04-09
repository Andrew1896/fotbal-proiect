package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.entity.Team;
import java.util.List;

public interface TeamService {

    List<Team> getAllTeams();

    void saveTeam(Team team);

    Team getTeam(Long id);

    void deleteTeam(Long id);
}