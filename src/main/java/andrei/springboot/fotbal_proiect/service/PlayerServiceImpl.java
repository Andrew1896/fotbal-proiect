package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.dao.PlayerRepository;
import andrei.springboot.fotbal_proiect.entity.Player;
import andrei.springboot.fotbal_proiect.entity.Team;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Player getPlayer(int id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Player not found with id: " + id));
    }

    @Override
    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<Player>findAllByName(String name) {
        return playerRepository.findAllByName(name);
    }
}
