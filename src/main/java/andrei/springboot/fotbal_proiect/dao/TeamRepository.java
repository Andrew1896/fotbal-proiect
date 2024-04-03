package andrei.springboot.fotbal_proiect.dao;

import andrei.springboot.fotbal_proiect.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
//    List<Player> findPlayersById(Long teamId);
//    Optional<Team> findById(Long teamId);
    Team findByName(String name);
}
