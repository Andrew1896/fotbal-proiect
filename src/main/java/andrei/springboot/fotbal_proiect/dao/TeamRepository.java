package andrei.springboot.fotbal_proiect.dao;

import andrei.springboot.fotbal_proiect.entity.Player;
import andrei.springboot.fotbal_proiect.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
//    public List<Team> findAllByName(String name);
}
