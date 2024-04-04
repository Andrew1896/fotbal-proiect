package andrei.springboot.fotbal_proiect.dao;

import andrei.springboot.fotbal_proiect.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    Team findByName(String name);
    Optional<Team> findById(Long teamId);
}
