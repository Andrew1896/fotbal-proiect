package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.entity.Team;
import java.util.List;

public interface TeamService {

    public List<Team> getAllTeams();

    public void saveTeam(Team team);

    public Team getTeam(int id);

    public void deleteTeam(int id);

}