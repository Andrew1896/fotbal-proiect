package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.dao.PlayerRepository;
import andrei.springboot.fotbal_proiect.dao.TeamRepository;
import andrei.springboot.fotbal_proiect.entity.Player;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

//@Service
public class PlayerServiceImpl implements PlayerService {
//
//    private final PlayerRepository playerRepository;
//    private final TeamRepository teamRepository;
//
//    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
//        this.playerRepository = playerRepository;
//        this.teamRepository = teamRepository;
//    }
//
//    @Override
//    public List<Player> getAllPlayers() {
//        return playerRepository.findAll();
//    }
//
//    @Override
//    public void savePlayer(Player player) {
//        playerRepository.save(player);
//    }
//
//    @Override
//    public Player getPlayer(int id) {
//        return playerRepository.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Player not found with id: " + id));
//    }
//
//    @Override
//    public void deletePlayer(int id) {
//        playerRepository.deleteById(id);
//    }

//    @Override
//    public List<Player> getP(String teamName) {
//        List <Team> teams = teamRepository.findAllByName(teamName);
//        if (!teams.isEmpty()) {
//            Team team = teams.get(0);
//            return team.getPlayers();
//        } else {
//            return null;
//        }
}
