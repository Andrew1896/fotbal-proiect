package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.dao.MatchRepository;
import andrei.springboot.fotbal_proiect.entity.Match;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
}
