package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.dao.PlayerRepository;
import andrei.springboot.fotbal_proiect.dao.TeamRepository;
import andrei.springboot.fotbal_proiect.entity.Player;
import andrei.springboot.fotbal_proiect.entity.Team;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;


    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
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
    public Player getPlayer(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Player not found with id: " + id));
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<Player> getPlayersByTeamId(Long teamId) {
        Optional<Team> team = teamRepository.findById(teamId);
        if (team.isEmpty()) {
            throw new RuntimeException();
        }
        return playerRepository.findByTeam(team.get());
    }
}
