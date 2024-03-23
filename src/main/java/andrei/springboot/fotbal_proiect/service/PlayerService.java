package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.entity.Player;
import java.util.List;

public interface PlayerService {

    public List<Player> getAllPlayers();

    public void savePlayer (Player player);

    public Player getPlayer (int id);

    public void deletePlayer (int id);
}
