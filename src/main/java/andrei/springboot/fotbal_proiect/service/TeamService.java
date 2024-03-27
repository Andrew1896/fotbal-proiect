package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.entity.Team;
import java.util.List;

public interface TeamService {

    public List<Team> getAllTeams(); // TODO: 27.03.2024 Modificatorul de access pubic este inutil, toate metodele din interfete sunt publice

    public void saveTeam(Team team); // TODO: 27.03.2024 Modificatorul de access pubic este inutil, toate metodele din interfete sunt publice

    public Team getTeam(int id); // TODO: 27.03.2024 Modificatorul de access pubic este inutil, toate metodele din interfete sunt publice

    public void deleteTeam(int id); // TODO: 27.03.2024 Modificatorul de access pubic este inutil, toate metodele din interfete sunt publice

    public List<Team> findAllByName(String name); // TODO: 27.03.2024 Modificatorul de access pubic este inutil, toate metodele din interfete sunt publice
}