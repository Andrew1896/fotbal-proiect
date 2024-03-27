package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.entity.Player;
import java.util.List;

public interface PlayerService {

    public List<Player> getAllPlayers(); // TODO: 27.03.2024 Modificatorul de access pubic este inutil, toate metodele din interfete sunt publice

    public void savePlayer(Player player); // TODO: 27.03.2024 Modificatorul de access pubic este inutil, toate metodele din interfete sunt publice

    public Player getPlayer(int id); // TODO: 27.03.2024 Modificatorul de access pubic este inutil, toate metodele din interfete sunt publice

    public void deletePlayer(int id); // TODO: 27.03.2024 Modificatorul de access pubic este inutil, toate metodele din interfete sunt publice

//    public List<Player> findAllByName(String name);
}