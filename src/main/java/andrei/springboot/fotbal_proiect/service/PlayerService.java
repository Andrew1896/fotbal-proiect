package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.entity.Player;
import java.util.List;

public interface PlayerService {

    List<Player> getAllPlayers();

    void savePlayer(Player player);

    Player getPlayer(Long id);

    void deletePlayer(Long id);

    List<Player> getPlayersByTeamId(Long teamId);
}