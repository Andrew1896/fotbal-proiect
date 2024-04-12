package andrei.springboot.fotbal_proiect.dao;

import andrei.springboot.fotbal_proiect.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface MatchRepository extends JpaRepository <Match, Long> {
    List<Match> findByDate(LocalDate now);
}
