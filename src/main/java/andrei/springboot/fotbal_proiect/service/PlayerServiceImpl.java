package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.dao.PlayerRepository;
import andrei.springboot.fotbal_proiect.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers () {
        return playerRepository.findAll();
    }

    @Override
    public void savePlayer (Player player) {
        playerRepository.save(player);
    }

    @Override
    public Player getPlayer (int id) {
        Player player = null;
        Optional<Player> optional = playerRepository.findById(id);
        if (optional.isPresent()) {
            player = optional.get();
        }
        return player;
    }

    @Override
    public void deletePlayer (int id) {
        playerRepository.deleteById(id);
    }
//        @Override
//        public List<Player> findAllByName(String name) {
//            List<Player> players = playerRepository.findAllByName(name);
//            return players;
//        }
}
