package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.entity.Team;
import java.util.List;

public interface TeamService {

    List<Team> getAllTeams();

    void saveTeam(Team team);

    Team getTeam(int id);

    void deleteTeam(int id);

    //    List<Player> getPlayersByTeamId(Long teamName);
}