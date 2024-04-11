package andrei.springboot.fotbal_proiect.dao;

import andrei.springboot.fotbal_proiect.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository <Match, Long> {
}
