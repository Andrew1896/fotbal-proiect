package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.entity.Player;
import andrei.springboot.fotbal_proiect.entity.Team;

import java.util.List;

public interface PlayerService {

    List<Player> getAllPlayers();

    void savePlayer(Player player);

    Player getPlayer(int id);

    void deletePlayer(int id);

    List<Player> findAllByName(String teamName);
}